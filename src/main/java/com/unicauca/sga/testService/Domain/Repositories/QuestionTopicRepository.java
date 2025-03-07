package com.unicauca.sga.testService.Domain.Repositories;

import com.unicauca.sga.testService.Domain.Entities.QuestionTopic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTopicRepository extends JpaRepository<QuestionTopic, Integer> {

}
