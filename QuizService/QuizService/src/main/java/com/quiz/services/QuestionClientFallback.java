package com.quiz.services;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.quiz.entities.Question;

@Component
public class QuestionClientFallback implements QuestionClient {

    @Override
    public List<Question> getQuestionOfQuiz(Long quizId) {
        System.out.println("Fallback triggered: Question Service is down!");
        return Collections.emptyList();  
    }
}
