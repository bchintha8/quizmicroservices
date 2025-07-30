package com.web_app.question_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int questionId;
    @NotNull
    private String questionTitle;
    @NotNull
    private String option1;
    @NotNull
    private String option2;
    @NotNull
    private String option3;
    @NotNull
    private String option4;
    @NotNull
    private String rightAnswer;
    @NotNull
    private String category;
}
