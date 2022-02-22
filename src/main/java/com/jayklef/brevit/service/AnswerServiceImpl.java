package com.jayklef.brevit.service;

import com.jayklef.brevit.model.Answers;
import com.jayklef.brevit.repository.AnswersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerServiceImpl implements AnswerService{

    @Autowired
    private AnswersRepository answersRepository;

    @Override
    public Answers findAllAnswers() {
        return null;
    }

    @Override
    public Answers addAnswers(Answers answers) {
        return null;
    }
}
