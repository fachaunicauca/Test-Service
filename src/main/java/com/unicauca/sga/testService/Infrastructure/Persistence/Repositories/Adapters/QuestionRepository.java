package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.Adapters;

import com.unicauca.sga.testService.Domain.Model.Question;
import com.unicauca.sga.testService.Domain.Ports.Repositories.IQuestionRepository;
import com.unicauca.sga.testService.Infrastructure.Mappers.QuestionMapper;
import com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.QuestionJpaRepository;

import java.util.List;
import java.util.stream.Collectors;

public class QuestionRepository implements IQuestionRepository {
    private final QuestionJpaRepository questionJpaRepository;
    private final QuestionMapper questionMapper;

    public QuestionRepository (QuestionJpaRepository questionJpaRepository, QuestionMapper questionMapper){
        this.questionJpaRepository=questionJpaRepository;
        this.questionMapper=questionMapper;
    }

    @Override
    public List<Question> findAll() {
        return questionJpaRepository.findAll().stream().map(questionMapper::toModel).collect(Collectors.toList());
    }

    @Override
    public Question findById(long id) {
        return questionMapper.toModel(questionJpaRepository.findById(id).get());
    }

    @Override
    public void save(Question question) {
        questionJpaRepository.save(questionMapper.toInfra(question));
    }

    @Override
    public void delete(Question question) {
        questionJpaRepository.delete(questionMapper.toInfra(question));
    }

    @Override
    public void deleteById(long id) {
        questionJpaRepository.deleteById(id);
    }

    @Override
    public List<Question> findRandom(int n) {
        return questionJpaRepository.findRandom(n).stream().map(questionMapper::toModel).collect(Collectors.toList());
    }
}
