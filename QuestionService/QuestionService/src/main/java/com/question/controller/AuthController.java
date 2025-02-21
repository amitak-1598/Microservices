package com.question.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.servlet.http.HttpSession;



@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public String login(HttpSession session) {
      
        String sessionId = session.getId();

       
        session.setAttribute("username", "user123");

        return "Session created with ID: " + sessionId;
    }

    @GetMapping("/session")
    public String getSession(HttpSession session) {
        return "Session ID: " + session.getId() + ", Username: " + session.getAttribute("username");
    }
}
