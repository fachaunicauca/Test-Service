package com.unicauca.sga.testService.Domain.Repositories;

import com.unicauca.sga.testService.Domain.Entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByTopicId(int question_topic_id);
}
