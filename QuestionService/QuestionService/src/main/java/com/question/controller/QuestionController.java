package com.question.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionService;
import com.question.services.QuestionServiceImp;

@RestController
@RequestMapping("/question")
public class QuestionController {

	private QuestionService questionservice;
	private QuestionServiceImp questionserviceimp;

	public QuestionController(QuestionService questionservice,QuestionServiceImp questionserviceimp) {
		this.questionservice = questionservice;
		this.questionserviceimp=questionserviceimp;
	}

	@PostMapping
	public Question save(@RequestBody Question question) {
		return questionservice.add(question);
	}

	@GetMapping
	public List<Question> get() {
		return questionservice.get();
	}
	
	@GetMapping("{id}")
	public Question getQuestion(@PathVariable Long id) {
		return questionservice.get(id);
	}
	    
//	@GetMapping("{id}")
//	public Question getOne(@PathVariable Long id) {
//		return questionserviceimp.findByIdInQuestion(id);
//	}

	
	
	
	@GetMapping({ "/quiz/{id}" })
	public List<Question> getQuestionByquizId(@PathVariable Long id) {
		return questionservice.getQuestionOfQuiz(id);
	}
	
//	@GetMapping({ "/quiz/{id}" })
//	public ResponseEntity<List<Question>> getQuestionByquizId(@PathVariable Long id) {
//		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
//		
//	}
}
