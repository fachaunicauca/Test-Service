package com.unicauca.sga.testService.Domain.IServices;

import com.unicauca.sga.testService.Domain.Entities.Test;

import java.util.List;

public interface ITestService {
    List<Test> getAllTests();
    Test getTestById(long id);
    void saveTest(Test test);
    void deleteTest(Test test);
    void deleteTestById(long id);
    void updateTest(Test test);
}
