package com.quiz.services;

import java.util.Collections;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.quiz.entities.Question;

import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;


@FeignClient(name="QUESTIONSERVICE")//, fallback = QuestionClientFallback.class
@CircuitBreaker(name = "questionServiceCircuitBreaker", fallbackMethod = "questionServiceFallback")
public interface QuestionClient {

	@GetMapping("/question/quiz/{quizId}")
	List<Question> getQuestionOfQuiz(@PathVariable Long quizId);
	
	default List<Question> questionServiceFallback(Long quizId, Throwable throwable) {
		
        if (throwable instanceof CallNotPermittedException) {
            
        	System.out.println("CircuitBreaker is OPEN, returning fallback.");
            return Collections.emptyList(); 
        }
        
        return Collections.emptyList();
    }

}
