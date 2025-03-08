package com.unicauca.sga.testService.Aplication.Services;

import com.unicauca.sga.testService.Domain.Model.QuestionTopic;
import com.unicauca.sga.testService.Domain.Ports.Repositories.IQuestionTopicRepository;
import com.unicauca.sga.testService.Domain.Ports.Services.IQuestionTopicService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTopicService implements IQuestionTopicService {

    private IQuestionTopicRepository questionTopicRepository;

    public QuestionTopicService(IQuestionTopicRepository questionTopicRepository) {
        this.questionTopicRepository = questionTopicRepository;
    }

    public List<QuestionTopic> getAllQuestionTopics(){
        return (List<QuestionTopic>) questionTopicRepository.findAll();
    }

    public QuestionTopic getQuestionTopicById(int id){
        return questionTopicRepository.findById(id);
    }

    public void saveQuestionTopic(QuestionTopic questionTopic){
        questionTopicRepository.save(questionTopic);
    }

    public void deleteQuestionTopic(QuestionTopic questionTopic){
        questionTopicRepository.delete(questionTopic);
    }

    public void deleteQuestionTopicById(int id){
        questionTopicRepository.deleteById(id);
    }

    public void updateQuestionTopic(QuestionTopic questionTopic){
        questionTopicRepository.save(questionTopic);
    }
}
