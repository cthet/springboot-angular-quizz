package com.example.quizz.repository;

import com.example.quizz.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {

    @Query(value = "SELECT * FROM question WHERE quiz_id = :quizzId ORDER BY RAND() LIMIT 20", nativeQuery = true)
    Optional<List<Question>> findByQuizId20Random(Integer quizzId);
}
