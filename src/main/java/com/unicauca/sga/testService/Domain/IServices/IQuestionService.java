package com.unicauca.sga.testService.Domain.IServices;

import com.unicauca.sga.testService.Domain.Entities.Question;

import java.util.List;

public interface IQuestionService {
    List<Question> getAllQuestions();
    Question getQuestionById(long id);
    void saveQuestion(Question question);
    void deleteQuestion(Question question);
    void deleteQuestionById(long id);
    void updateQuestion(Question question);

}
