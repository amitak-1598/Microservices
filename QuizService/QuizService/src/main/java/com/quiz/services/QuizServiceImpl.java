package com.quiz.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.quiz.entities.Quiz;
import com.quiz.repositories.QuizRepository;

@Service
public class QuizServiceImpl implements QuizService {

	private QuizRepository quizrepository;

	private QuestionClient questionclient;

	public QuizServiceImpl(QuizRepository quizRepository, QuestionClient questionclient) {
		this.quizrepository = quizRepository;
		this.questionclient = questionclient;
	}

	@Override
	public Quiz add(Quiz quiz) {

		return quizrepository.save(quiz);
	}

	@Override
	public List<Quiz> get() {
		List<Quiz> quizes = quizrepository.findAll();

		List<Quiz> newQuizList = quizes.stream().map(quiz -> {
			quiz.setQuestions(questionclient.getQuestionOfQuiz(quiz.getId()));
			return quiz;
		}).collect(Collectors.toList());
		return newQuizList;
	}

	@Override
	public Quiz get(Long id) {

		Quiz quiz = quizrepository.findById(id).orElseThrow(() -> new RuntimeException("Quiz not found"));
		quiz.setQuestions(questionclient.getQuestionOfQuiz(quiz.getId()));
		return quiz;
	}

}
