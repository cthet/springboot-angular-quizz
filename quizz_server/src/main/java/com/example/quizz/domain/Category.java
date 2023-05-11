package com.example.quizz.domain;

import com.example.quizz.view.Views;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "category")
@Data
public class Category {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "category")
    @JsonView(Views.CategorySummary.class)
    private List<Quiz> quizzes;
}
