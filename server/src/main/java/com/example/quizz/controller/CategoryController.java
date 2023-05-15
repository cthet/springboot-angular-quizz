package com.example.quizz.controller;

import com.example.quizz.domain.Category;
import com.example.quizz.exception.ApiRequestException;
import com.example.quizz.repository.CategoryRepository;
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
public class CategoryController {

    @Autowired
    CategoryRepository repository;

    @GetMapping("/categories")
    @JsonView(Views.CategorySummary.class)
    public ResponseEntity<?> getCategoriesSummary() {
        try{
            List<Category> categories = repository.findAll();
            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/category/{categoryId}")
    @JsonView(Views.CategoryDetails.class)
    public ResponseEntity<?> getCategoryDetails(@PathVariable Integer categoryId) {
        try{
            Category category = repository.findById(categoryId)
                    .orElseThrow(() -> new ApiRequestException("Categories not found!", HttpStatus.NOT_FOUND));
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
