package com.unicauca.sga.testService.Domain.Ports.Services;

import com.unicauca.sga.testService.Domain.Model.Answer;

import java.util.List;

public interface IAnswerService {
    List<Answer> getAllAnswers();
    Answer getAnswerById(long id);
    void saveAnswer(Answer answer);
    void deleteAnswer(Answer answer);
    void deleteAnswerById(long id);
    void updateAnswer(Answer answer);
    boolean answerIsCorrect(long id);
}
