package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.Adapters;

import com.unicauca.sga.testService.Domain.Model.QuestionTopic;
import com.unicauca.sga.testService.Domain.Ports.Repositories.IQuestionTopicRepository;
import com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.QuestionTopicJpaRepository;

import java.util.List;

public class QuestionTopicRepository implements IQuestionTopicRepository {
    private final QuestionTopicJpaRepository questionTopicJpaRepository;

    public QuestionTopicRepository (QuestionTopicJpaRepository questionTopicJpaRepository){
        this.questionTopicJpaRepository=questionTopicJpaRepository;
    }


    @Override
    public List<QuestionTopic> findAll() {
        return questionTopicJpaRepository.findAll();
    }

    @Override
    public QuestionTopic findById(int id) {
        return questionTopicJpaRepository.findById(id).get();
    }

    @Override
    public void save(QuestionTopic questionTopic) {
        questionTopicJpaRepository.save(questionTopic);
    }

    @Override
    public void delete(QuestionTopic questionTopic) {
        questionTopicJpaRepository.delete(questionTopic);
    }

    @Override
    public void deleteById(int id) {
        questionTopicJpaRepository.deleteById(id);
    }
}
