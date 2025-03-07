package com.unicauca.sga.testService.Domain.Repositories;

import com.unicauca.sga.testService.Domain.Entities.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {
}
