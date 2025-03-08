package com.unicauca.sga.testService.Aplication.Services;

import com.unicauca.sga.testService.Domain.Model.Question;
import com.unicauca.sga.testService.Domain.Ports.Repositories.IQuestionRepository;
import com.unicauca.sga.testService.Domain.Ports.Services.IQuestionService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService implements IQuestionService {

    private IQuestionRepository questionRepository;

    public QuestionService(IQuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> getAllQuestions(){
        return (List<Question>) questionRepository.findAll();
    }

    public Question getQuestionById(long id){
        return questionRepository.findById(id);
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
