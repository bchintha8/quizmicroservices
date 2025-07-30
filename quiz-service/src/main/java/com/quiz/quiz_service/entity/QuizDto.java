package com.quiz.quiz_service.entity;

import lombok.Data;

@Data
public class QuizDto {
    private int NoOfQuestions;
    private String category;
    private String title;
}
