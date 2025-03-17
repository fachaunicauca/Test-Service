package com.unicauca.sga.testService.Domain.Ports.Services;


import com.unicauca.sga.testService.Domain.Model.Test;

import java.util.List;

public interface ITestService {
    List<Test> getAllTests();
    Test getTestById(long id);
    void saveTest(Test test);
    void deleteTest(Test test);
    void deleteTestById(long id);
    void updateTest(Test test);
    boolean isPresent(long id);
}
