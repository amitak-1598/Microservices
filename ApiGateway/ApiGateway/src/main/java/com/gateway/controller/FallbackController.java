package com.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
	
	
    @GetMapping("/quizServiceFallback")
    public String quizServiceFallback() {
        return "Quiz Service is currently unavailable. Please try again later.";
    }
}
