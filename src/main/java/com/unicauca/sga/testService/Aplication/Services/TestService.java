package com.unicauca.sga.testService.Aplication.Services;

import com.unicauca.sga.testService.Domain.IServices.ITestService;
import com.unicauca.sga.testService.Domain.Entities.Test;
import com.unicauca.sga.testService.Domain.Repositories.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestService implements ITestService {

    @Autowired
    private TestRepository testRepository;

    public List<Test> getAllTests(){
        return testRepository.findAll();
    }

    public Test getTestById(long id){
        if(testRepository.findById(id).isPresent()){
            return testRepository.findById(id).get();
        }
        return null;
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
