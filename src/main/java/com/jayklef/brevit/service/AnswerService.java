package com.jayklef.brevit.service;

import com.jayklef.brevit.model.Answers;

public interface AnswerService {
    Answers findAllAnswers();

    Answers addAnswers(Answers answers);
}
