package com.question.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.question.entities.Question;
import com.question.services.QuestionService;

@RestController
@RequestMapping("/question")
public class QuestionController {

	private QuestionService questionservice;

	public QuestionController(QuestionService questionservice) {
		this.questionservice = questionservice;
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
	public Question getOne(@PathVariable Long id) {
		return questionservice.get(id);
	}

	@GetMapping({ "/quiz/{id}" })
	public List<Question> getQuestionByquizId(@PathVariable Long id) {
		return questionservice.getQuestionOfQuiz(id);
	}
}
