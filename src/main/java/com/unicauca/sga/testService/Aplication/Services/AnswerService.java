package com.unicauca.sga.testService.Aplication.Services;

import com.unicauca.sga.testService.Domain.Model.Answer;
import com.unicauca.sga.testService.Domain.Ports.Repositories.IAnswerRepository;
import com.unicauca.sga.testService.Domain.Ports.Services.IAnswerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnswerService implements IAnswerService {


    private final IAnswerRepository answerRepository;

    public AnswerService(IAnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public List<Answer> getAllAnswers(){
        return (List<Answer>) answerRepository.findAll();
    }

    public Answer getAnswerById(long id){
        return answerRepository.findById(id);
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

    public List<Answer> getAllAnswersByQuestion(long q_id) {
        return answerRepository.findByQuestionId(q_id);
    }

    public boolean answerIsCorrect(long id){
        return answerRepository.isCorrect(id);
    }
}
