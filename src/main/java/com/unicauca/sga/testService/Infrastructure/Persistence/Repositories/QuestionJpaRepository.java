package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories;

import com.unicauca.sga.testService.Infrastructure.Persistence.Tables.QuestionTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionJpaRepository extends JpaRepository<QuestionTable, Long> {
    @Query("SELECT * FROM Question ORDER BY RAND() WHERE subject_name=:subject_name LIMIT :n")
    List<QuestionTable> findRandomBySubject(@Param("n") String subject_name, @Param("n") int n);
}
