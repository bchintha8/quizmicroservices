package com.web_app.question_service.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
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



