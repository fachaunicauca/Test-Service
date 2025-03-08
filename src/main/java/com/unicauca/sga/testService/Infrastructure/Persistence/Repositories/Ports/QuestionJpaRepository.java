package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.Ports;

import com.unicauca.sga.testService.Infrastructure.Persistence.Entities.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionEntity, Long> {
    List<QuestionEntity> findByTopicId(int question_topic_id);
}
