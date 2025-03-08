package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.Ports;

import com.unicauca.sga.testService.Infrastructure.Persistence.Entities.QuestionTopicEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionTopicJpaRepository extends JpaRepository<QuestionTopicEntity, Integer> {

}
