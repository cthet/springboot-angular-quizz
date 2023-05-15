package com.example.quizz.controller;

import com.example.quizz.domain.Question;
import com.example.quizz.domain.Quiz;
import com.example.quizz.exception.ApiRequestException;
import com.example.quizz.repository.QuestionRepository;
import com.example.quizz.repository.QuizRepository;
import com.example.quizz.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class QuizController {

    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    @GetMapping("/quiz/{quizzId}")
    @JsonView(Views.QuizSummary.class)
    public ResponseEntity<?> getJavaQuizDetails(@PathVariable Integer quizzId){
        try{

            Quiz quiz = quizRepository.findById(quizzId)
                    .orElseThrow(() -> new ApiRequestException("Quiz not found !", HttpStatus.NOT_FOUND));

            List<Question> questions = questionRepository.findByQuizId20Random(quizzId)
                    .orElseThrow(() -> new ApiRequestException("questions not found!", HttpStatus.NOT_FOUND));

            quiz.setQuestions(questions);

            return new ResponseEntity<>(quiz, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
