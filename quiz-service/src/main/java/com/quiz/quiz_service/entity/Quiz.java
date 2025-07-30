package com.quiz.quiz_service.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int quizId;
    private String quizTitle;
    @ElementCollection
    private List<Integer> qurstionIds;

}
