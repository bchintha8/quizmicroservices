package com.quiz.quiz_service.controller;

import com.quiz.quiz_service.entity.QuestionWrapper;
import com.quiz.quiz_service.entity.QuizDto;
import com.quiz.quiz_service.entity.Response;
import com.quiz.quiz_service.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class Qcontroller {

    @Autowired
    private QuizService quizService;


    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto q){
        return quizService.create(q);
    }

    @PostMapping("/getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> e){
        return quizService.getQuestions(e);
    }

    @PostMapping("/response")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> rt){
        return quizService.getScore(rt);

    }

}
