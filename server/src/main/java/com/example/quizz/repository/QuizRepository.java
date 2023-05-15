package com.example.quizz.repository;

import com.example.quizz.domain.Quiz;
import com.example.quizz.exception.ApiRequestException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer> {
    default Quiz quizValidation(Quiz quiz){
        if(quiz.equals(null)){
            throw new ApiRequestException("Quiz not found!", HttpStatus.NOT_FOUND);
        }
        return quiz;
    }

    @Query(value = "SELECT q.* FROM quiz q " +
            "JOIN (SELECT quiz_id from question ORDER BY RAND() LIMIT 20) qst " +
            "ON qst.quiz_id = q.id " +
            "WHERE q.id = :id", nativeQuery = true)
    Quiz findByIdWithRandomQuestions(Integer id);
}
