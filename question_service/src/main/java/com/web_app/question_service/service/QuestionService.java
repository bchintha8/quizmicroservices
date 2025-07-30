package com.web_app.question_service.service;

import com.web_app.question_service.entity.Question;
import com.web_app.question_service.entity.QuestionWrapper;
import com.web_app.question_service.entity.Response;
import com.web_app.question_service.repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {

    @Autowired
    private QuestionRepo questionRepo;

    public ResponseEntity<String> questionAdd(Question q) {
        questionRepo.save(q);
        return new ResponseEntity<String>("Question Added", HttpStatus.CREATED);
    }

    public ResponseEntity<List<Question>> getQuestions() {
        List<Question> all = questionRepo.findAll();
        return new ResponseEntity<>(all,HttpStatus.FOUND);

    }


    public ResponseEntity<String> deleteQuestion(int d) {
        questionRepo.deleteById(d);
        return new ResponseEntity<String>("Deleted successfully",HttpStatus.GONE);
    }

    public ResponseEntity<List<Integer>> getQuestion(int numberOfQuestion, String category) {

        List<Integer> nums=new ArrayList<>();
        List<Question> questions=questionRepo.findByCategory(category).stream().limit(numberOfQuestion).toList();

        for(Question q:questions){
            nums.add(q.getQuestionId());
        }


        return new ResponseEntity<List<Integer>>(nums,HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuestionByIds(List<Integer> r) {

        List<Question> questionList=new ArrayList<>();
        List<QuestionWrapper> wrappers1 =new ArrayList<>();
        for(Integer l:r){
            Question m1=questionRepo.findById(l).get();
            questionList.add(m1);
        }
        for(Question q1:questionList){

            QuestionWrapper we= new QuestionWrapper(q1.getQuestionId(),q1.getQuestionTitle(),q1.getOption1(), q1.getOption2(), q1.getOption3(),q1.getOption4(),q1.getCategory());
            wrappers1.add(we);
        }

return new ResponseEntity<List<QuestionWrapper>>(wrappers1,HttpStatus.FOUND);
    }

    public ResponseEntity<Integer> getScore(List<Response> responses) {
        List<Question> quizQuestions =new ArrayList<>();
        int score=0;
        for(Response r:responses) {
            Question k = questionRepo.findById(r.getId()).get();
            if (k.getRightAnswer().equals(r.getResponse())) {
                score++;
            }


        }
        return new ResponseEntity<Integer>(score,HttpStatus.CREATED);
    }
}
