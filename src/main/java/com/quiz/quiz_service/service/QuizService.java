package com.quiz.quiz_service.service;


import com.quiz.quiz_service.entity.QuestionWrapper;
import com.quiz.quiz_service.entity.Quiz;
import com.quiz.quiz_service.entity.QuizDto;
import com.quiz.quiz_service.entity.Response;
import com.quiz.quiz_service.feign.QuizFeign;
import com.quiz.quiz_service.repo.QuizRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    @Autowired
    private QuizRepo quizRepo;

    @Autowired
    private QuizFeign quizFeign;

    public ResponseEntity<String> create(QuizDto q1) {
        Quiz q=new Quiz();
       List<Integer> qids= quizFeign.getQuestions(q1.getNoOfQuestions(), q1.getCategory()).getBody();
       q.setQuizTitle(q1.getTitle());
       q.setQurstionIds(qids);
        quizRepo.save(q);
       return new ResponseEntity<String>("Created",HttpStatus.CREATED);

    }

    public ResponseEntity<List<QuestionWrapper>> getQuestions(List<Integer> e) {
    List<QuestionWrapper> wrappers= quizFeign.getQuestionIds(e).getBody();
    return new ResponseEntity<List<QuestionWrapper>>(wrappers,HttpStatus.ACCEPTED);
    }


    public ResponseEntity<Integer> getScore(List<Response> rt) {
        Integer o=quizFeign.getScore(rt).getBody();

        return new ResponseEntity<Integer>(o,HttpStatus.FOUND);
    }
}
