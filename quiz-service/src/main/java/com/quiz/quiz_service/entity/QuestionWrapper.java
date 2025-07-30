package com.quiz.quiz_service.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuestionWrapper {
    private int questionId;
    private String questionTitle;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String category;
}



