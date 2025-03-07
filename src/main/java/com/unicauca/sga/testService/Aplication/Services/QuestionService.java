package com.unicauca.sga.testService.Aplication.Services;

import com.unicauca.sga.testService.Domain.IServices.IQuestionService;
import com.unicauca.sga.testService.Domain.Entities.Question;
import com.unicauca.sga.testService.Domain.Repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> getAllQuestions(){
        return (List<Question>) questionRepository.findAll();
    }

    public Question getQuestionById(long id){
        if(questionRepository.findById(id).isPresent()){
            return questionRepository.findById(id).get();
        }
        return null;
    }

    public void saveQuestion(Question question){
        questionRepository.save(question);
    }

    public void deleteQuestion(Question question){
        questionRepository.delete(question);
    }

    public void deleteQuestionById(long id){
        questionRepository.deleteById(id);
    }

    public void updateQuestion(Question question){
        questionRepository.save(question);
    }
}
