package com.example.quizz.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "question")
@Data
public class Question {

    @Id
    private int id;

    @Column(name = "content")
    private String content;

    @Column(name = "img")
    private String url;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    @JsonIgnore
    private Quiz quiz;

    @OneToMany(mappedBy = "question")
    private List<Choice> choices;

    @OneToOne
    @JoinTable(name = "answer", joinColumns = {
            @JoinColumn(name = "question_id", referencedColumnName = "id")
    }, inverseJoinColumns = {
            @JoinColumn(name = "choice_id", referencedColumnName = "id", nullable = false)
    })
    private Choice answer;

}
