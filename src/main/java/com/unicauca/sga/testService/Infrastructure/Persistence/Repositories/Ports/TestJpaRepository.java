package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.Ports;

import com.unicauca.sga.testService.Infrastructure.Persistence.Entities.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestJpaRepository extends JpaRepository<TestEntity, Long> {
}
