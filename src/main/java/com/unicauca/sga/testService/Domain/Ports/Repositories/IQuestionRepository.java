package com.unicauca.sga.testService.Domain.Ports.Repositories;


import com.unicauca.sga.testService.Domain.Model.Question;

import java.util.List;

public interface IQuestionRepository {
    List<Question> findAll();
    Question findById(long id);
    void save(Question question);
    void delete(Question question);
    void deleteById(long id);
    List<Question> findRandom(int n);
}
