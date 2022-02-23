package com.jayklef.brevit.controller;

import com.jayklef.brevit.model.Answers;
import com.jayklef.brevit.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("answers")
public class AnswersController {

    @Autowired
    private AnswerService answerService;

    @GetMapping("/all")
    public ResponseEntity<Answers> findAllAnswers(){
        Answers answersList = answerService.findAllAnswers();
        return new ResponseEntity<>(answersList, HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Answers> addAnswers(@RequestBody Answers answers){
        Answers newAnswer = answerService.addAnswers(answers);
        return new ResponseEntity<>(newAnswer, HttpStatus.CREATED);
    }
}
