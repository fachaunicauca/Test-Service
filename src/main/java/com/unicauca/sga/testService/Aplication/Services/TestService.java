package com.unicauca.sga.testService.Aplication.Services;

import com.unicauca.sga.testService.Domain.Model.Test;
import com.unicauca.sga.testService.Domain.Ports.Repositories.ITestRepository;
import com.unicauca.sga.testService.Domain.Ports.Services.ITestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements ITestService {

    private ITestRepository testRepository;

    public TestService(ITestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public List<Test> getAllTests(){
        return testRepository.findAll();
    }

    public Test getTestById(long id){
        return testRepository.findById(id);
    }

    public void saveTest(Test test){
        testRepository.save(test);
    }

    public void deleteTest(Test test){
        testRepository.delete(test);
    }

    public void deleteTestById(long id){
        testRepository.deleteById(id);
    }

    public void updateTest(Test test){
        testRepository.save(test);
    }
}
