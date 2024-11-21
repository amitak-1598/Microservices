package com.quiz.controller;

import java.util.List;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.entities.Quiz;
import com.quiz.services.QuizService;

@RestController
@RequestMapping("/quiz")
public class QuizController {

	private QuizService quizservice;

	public QuizController(QuizService quizservice) {
		this.quizservice = quizservice;
	}

	@PostMapping
	public Quiz create(@RequestBody Quiz quiz) {
		return quizservice.add(quiz);
	}

	@GetMapping
	public List<Quiz> get() {
		return quizservice.get();
	}

	@GetMapping("{id}")
	public Quiz getOne(@PathVariable Long id) {
		return quizservice.get(id);
	}
	
	
}
