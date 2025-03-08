package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.Ports;

import com.unicauca.sga.testService.Infrastructure.Persistence.Entities.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerJpaRepository extends JpaRepository<AnswerEntity, Long> {
    @Query("SELECT a.answer_isCorrect FROM Answer a WHERE a.answer_id = :answer_id")
    boolean isCorrect(@Param("answer_id") long answer_id);
}
