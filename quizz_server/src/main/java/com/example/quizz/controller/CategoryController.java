package com.example.quizz.controller;

import com.example.quizz.domain.Category;
import com.example.quizz.repository.CategoryRepository;
import com.example.quizz.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    CategoryRepository repository;

    @GetMapping
    @JsonView(Views.CategorySummary.class)
    public ResponseEntity<?> getCategoriesSummary() {
        try{
            List<Category> categories = repository.categoryValidation(repository.findAll());
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
