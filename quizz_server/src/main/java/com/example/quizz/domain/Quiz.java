package com.example.quizz.domain;

import com.example.quizz.view.Views;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "quiz")
@Data
public class Quiz {

    @Id
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "quiz")
    @JsonView(Views.QuizSummary.class)
    private List<Question> questions;

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    @JsonIgnore
    private Category category;
}
