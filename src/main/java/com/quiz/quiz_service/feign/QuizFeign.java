package com.quiz.quiz_service.feign;

import com.quiz.quiz_service.entity.QuestionWrapper;
import com.quiz.quiz_service.entity.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("QUESTION-SERVICE" )
public interface QuizFeign {

    @GetMapping("question/generate")
    public ResponseEntity<List<Integer>> getQuestions(@RequestParam int NumberOfQuestion,@RequestParam String category);

    @GetMapping("question/get")
    public ResponseEntity<List<QuestionWrapper>> getQuestionIds(@RequestBody List<Integer> r);

    @GetMapping("question/score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);



}
