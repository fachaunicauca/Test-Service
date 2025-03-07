package com.unicauca.sga.testService.Domain.IServices;

import com.unicauca.sga.testService.Domain.Entities.QuestionTopic;

import java.util.List;

public interface IQuestionTopicService {
    List<QuestionTopic> getAllQuestionTopics();
    QuestionTopic getQuestionTopicById(int id);
    void saveQuestionTopic(QuestionTopic questionTopic);
    void deleteQuestionTopic(QuestionTopic questionTopic);
    void deleteQuestionTopicById(int id);
    void updateQuestionTopic(QuestionTopic questionTopic);
}
