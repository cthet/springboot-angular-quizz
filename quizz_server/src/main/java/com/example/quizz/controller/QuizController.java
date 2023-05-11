package com.example.quizz.controller;

import com.example.quizz.domain.Quiz;
import com.example.quizz.repository.QuizRepository;
import com.example.quizz.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quizzes")
public class QuizController {

    @Autowired
    QuizRepository repository;

    @GetMapping("/{quizzId}")
    @JsonView(Views.QuizSummary.class)
    public ResponseEntity<?> getJavaQuizDetails(@PathVariable Integer quizzId){
        try{
            Quiz quiz = repository.quizValidation(repository.findByIdWithRandomQuestions(quizzId));
            return new ResponseEntity<>(quiz, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
