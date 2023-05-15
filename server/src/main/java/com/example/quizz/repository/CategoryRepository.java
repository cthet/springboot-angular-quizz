package com.example.quizz.repository;

import com.example.quizz.domain.Category;
import com.example.quizz.exception.ApiRequestException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    default List<Category> categoryValidation(List<Category> categories){
        if(categories.isEmpty()){
            throw new ApiRequestException("Categories not found!", HttpStatus.NOT_FOUND);
        }
        return categories;
    }
}
