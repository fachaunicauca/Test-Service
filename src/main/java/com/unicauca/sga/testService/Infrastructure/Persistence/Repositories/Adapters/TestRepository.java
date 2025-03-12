package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.Adapters;

import com.unicauca.sga.testService.Domain.Model.Test;
import com.unicauca.sga.testService.Domain.Ports.Repositories.ITestRepository;
import com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.TestJpaRepository;

import java.util.List;

public class TestRepository implements ITestRepository {
    private final TestJpaRepository testJpaRepository;

    public TestRepository(TestJpaRepository testJpaRepository){
        this.testJpaRepository=testJpaRepository;
    }

    @Override
    public List<Test> findAll() {
        return testJpaRepository.findAll();
    }

    @Override
    public Test findById(long id) {
        return testJpaRepository.findById(id).get();
    }

    @Override
    public void save(Test test) {
        testJpaRepository.save(test);
    }

    @Override
    public void delete(Test test) {
        testJpaRepository.delete(test);
    }

    @Override
    public void deleteById(long id) {
        testJpaRepository.deleteById(id);
    }
}
