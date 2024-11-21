package com.question.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.question.entities.Question;
import com.question.repositories.QuestionRepository;

@Service
public class QuestionServiceImp implements QuestionService {

	private QuestionRepository questionrepository;

	public QuestionServiceImp(QuestionRepository questionrepository) {
		this.questionrepository = questionrepository;
	}

	@Override
	public Question add(Question question) {

		return questionrepository.save(question);
	}

	@Override
	public List<Question> get() {

		return questionrepository.findAll();
	}

	@Override
	public Question get(Long id) {
	
		return questionrepository.findById(id).orElseThrow(()-> new RuntimeException("Question Not Found or No question present"));
	}

	@Override
	public List<Question> getQuestionOfQuiz(Long id) {
		       
		return questionrepository.findByQuizId(id);
	}

	

}
