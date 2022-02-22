package com.jayklef.brevit.service;

import com.jayklef.brevit.model.Question;

import java.util.List;

public interface QuestionService {
    List<Question> findAllQuestions();

    Question addQuestion(Question question);

    Question updateQuestion(Long id, Question question);

    Question findQuestionById(Long id);
}
