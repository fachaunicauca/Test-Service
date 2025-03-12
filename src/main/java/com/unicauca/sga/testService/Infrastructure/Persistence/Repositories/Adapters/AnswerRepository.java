package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.Adapters;

import com.unicauca.sga.testService.Domain.Model.Answer;
import com.unicauca.sga.testService.Domain.Ports.Repositories.IAnswerRepository;
import com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.AnswerJpaRepository;

import java.util.List;

public class AnswerRepository implements IAnswerRepository {
    private final AnswerJpaRepository answerJpaRepository;

    public AnswerRepository (AnswerJpaRepository answerJpaRepository){
        this.answerJpaRepository=answerJpaRepository;
    }

    @Override
    public List<Answer> findAll() {
        return answerJpaRepository.findAll();
    }

    @Override
    public Answer findById(long id) {
        return answerJpaRepository.findById(id).get();
    }

    @Override
    public void save(Answer answer) {
        answerJpaRepository.save(answer);
    }

    @Override
    public void delete(Answer answer) {
        answerJpaRepository.delete(answer);
    }

    @Override
    public void deleteById(long id) {
        answerJpaRepository.deleteById(id);
    }

    @Override
    public List<Answer> findByQuestionId(long id) {
        return answerJpaRepository.findByQuestionId(id);
    }

    @Override
    public boolean isCorrect(long id) {
        return answerJpaRepository.isCorrect(id);
    }
}
