package com.question.services;

import java.util.List;

import com.question.entities.Question;

public interface QuestionService {

	
	  Question add (Question question);
	  
	  List<Question> get();
	  
	  Question get(Long id);
	  
	List<Question> getQuestionOfQuiz(Long id);
}
