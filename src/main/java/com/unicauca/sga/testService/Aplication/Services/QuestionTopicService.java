package com.unicauca.sga.testService.Aplication.Services;

import com.unicauca.sga.testService.Domain.IServices.IQuestionTopicService;
import com.unicauca.sga.testService.Domain.Entities.QuestionTopic;
import com.unicauca.sga.testService.Domain.Repositories.QuestionTopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionTopicService implements IQuestionTopicService {

    @Autowired
    private QuestionTopicRepository questionTopicRepository;

    public List<QuestionTopic> getAllQuestionTopics(){
        return (List<QuestionTopic>) questionTopicRepository.findAll();
    }

    public QuestionTopic getQuestionTopicById(int id){
        if(questionTopicRepository.findById(id).isPresent()){
            return questionTopicRepository.findById(id).get();
        }
        return null;
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
