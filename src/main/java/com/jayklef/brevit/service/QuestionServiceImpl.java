package com.jayklef.brevit.service;

import com.jayklef.brevit.model.Question;
import com.jayklef.brevit.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService{

    @Autowired
    private QuestionRepository questionRepository;

    @Override
    public List<Question> findAllQuestions() {
        return null;
    }

    @Override
    public Question addQuestion(Question question) {
        return null;
    }

    @Override
    public Question updateQuestion(Long id, Question question) {
        return null;
    }

    @Override
    public Question findQuestionById(Long id) {
        return null;
    }
}
