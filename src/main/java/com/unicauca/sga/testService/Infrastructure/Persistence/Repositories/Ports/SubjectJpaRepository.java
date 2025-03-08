package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.Ports;

import com.unicauca.sga.testService.Infrastructure.Persistence.Entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectJpaRepository extends JpaRepository<SubjectEntity, String> {
}
