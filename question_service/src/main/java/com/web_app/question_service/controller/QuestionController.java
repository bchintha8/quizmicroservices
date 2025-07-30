package com.web_app.question_service.controller;

import com.web_app.question_service.entity.Question;
import com.web_app.question_service.entity.QuestionWrapper;
import com.web_app.question_service.entity.Response;
import com.web_app.question_service.repo.QuestionRepo;
import com.web_app.question_service.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping("/add")
    public ResponseEntity<String> questionAdd(@RequestBody Question q){

        return questionService.questionAdd(q);
    }
    @GetMapping("/getall")
    public ResponseEntity<List<Question>> getQuestions(){
        return questionService.getQuestions();
    }
    @PostMapping("/delete/{d}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int d){
        return questionService.deleteQuestion(d);
    }

    @GetMapping("/generate")
    public ResponseEntity<List<Integer>> getQuestions(@RequestParam int NumberOfQuestion,@RequestParam String category){
        return questionService.getQuestion(NumberOfQuestion,category);
    }

    @GetMapping("/get")
    public ResponseEntity<List<QuestionWrapper>> getQuestionIds(@RequestBody List<Integer> r){
        return questionService.getQuestionByIds(r);

    }
@GetMapping("/score")
    public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses){
    return questionService.getScore(responses);

}



}
