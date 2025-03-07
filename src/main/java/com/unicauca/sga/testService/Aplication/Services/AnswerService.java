package com.unicauca.sga.testService.Aplication.Services;

import com.unicauca.sga.testService.Domain.IServices.IAnswerService;
import com.unicauca.sga.testService.Domain.Entities.Answer;
import com.unicauca.sga.testService.Domain.Repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService implements IAnswerService {

    @Autowired
    private AnswerRepository answerRepository;

    public List<Answer> getAllAnswers(){
        return (List<Answer>) answerRepository.findAll();
    }

    public Answer getAnswerById(long id){
        if(answerRepository.findById(id).isPresent()){
            return answerRepository.findById(id).get();
        }
        return null;
    }

    public void saveAnswer(Answer answer){
        answerRepository.save(answer);
    }

    public void deleteAnswer(Answer answer){
        answerRepository.delete(answer);
    }

    public void deleteAnswerById(long id){
        answerRepository.deleteById(id);
    }

    public void updateAnswer(Answer answer){
        answerRepository.save(answer);
    }

    public boolean answerIsCorrect(long id){
        return answerRepository.isCorrect(id);
    }
}
