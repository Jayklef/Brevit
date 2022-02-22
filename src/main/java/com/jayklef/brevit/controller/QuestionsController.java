package com.jayklef.brevit.controller;

import com.jayklef.brevit.model.Question;
import com.jayklef.brevit.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuestionsController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/all")
    public ResponseEntity<List<Question>> findAllQuestions(){
        List<Question> questionsList = questionService.findAllQuestions();
        return new ResponseEntity<>(questionsList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Question> addQuestion(@RequestBody Question question){
        Question newQuestion = questionService.addQuestion(question);
        return new ResponseEntity<>(newQuestion, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Question> updateQuestion(@PathVariable("id") Long id,
                                                   @RequestBody Question question){
        Question updateQuestion = questionService.updateQuestion(id, question);
        return new ResponseEntity<>(updateQuestion, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> findQuestionById(@PathVariable("id") Long id){
        Question question = questionService.findQuestionById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
}
