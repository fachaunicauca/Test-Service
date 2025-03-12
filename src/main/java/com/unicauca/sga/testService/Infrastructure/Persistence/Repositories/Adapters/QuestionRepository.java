package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.Adapters;

import com.unicauca.sga.testService.Domain.Model.Question;
import com.unicauca.sga.testService.Domain.Ports.Repositories.IQuestionRepository;
import com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.QuestionJpaRepository;

import java.util.List;

public class QuestionRepository implements IQuestionRepository {
    private final QuestionJpaRepository questionJpaRepository;

    public QuestionRepository (QuestionJpaRepository questionJpaRepository){
        this.questionJpaRepository=questionJpaRepository;
    }

    @Override
    public List<Question> findAll() {
        return questionJpaRepository.findAll();
    }

    @Override
    public Question findById(long id) {
        return questionJpaRepository.findById(id).get();
    }

    @Override
    public void save(Question question) {
        questionJpaRepository.save(question);
    }

    @Override
    public void delete(Question question) {
        questionJpaRepository.delete(question);
    }

    @Override
    public void deleteById(long id) {
        questionJpaRepository.deleteById(id);
    }

    @Override
    public List<Question> findRandom(int n) {
        return questionJpaRepository.findRandom(n);
    }
}
