package com.unicauca.sga.testService.Domain.Repositories;

import com.unicauca.sga.testService.Domain.Entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, String> {
}
