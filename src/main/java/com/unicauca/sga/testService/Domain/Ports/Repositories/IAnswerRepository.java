package com.unicauca.sga.testService.Domain.Ports.Repositories;

import com.unicauca.sga.testService.Domain.Model.Answer;

import java.util.AbstractList;
import java.util.List;

public interface IAnswerRepository {
    List<Answer> findAll();
    Answer findById(long id);
    void save(Answer answer);
    void delete(Answer answer);
    void deleteById(long id);
    List<Answer> findByQuestionId(long id);
    boolean isCorrect(long id);
}
