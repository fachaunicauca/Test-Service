package com.unicauca.sga.testService.Aplication.Services;

import com.unicauca.sga.testService.Domain.IServices.ISubjectService;
import com.unicauca.sga.testService.Domain.Entities.Subject;
import com.unicauca.sga.testService.Domain.Repositories.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects(){
        return (List<Subject>) subjectRepository.findAll();
    }

    public Subject getSubjectById(String id){
        if(subjectRepository.findById(id).isPresent()){
            return subjectRepository.findById(id).get();
        }
        return null;
    }

    public void saveSubject(Subject subject){
        subjectRepository.save(subject);
    }

    public void deleteSubject(Subject subject){
        subjectRepository.delete(subject);
    }

    public void deleteSubjectById(String id){
        subjectRepository.deleteById(id);
    }

    public void updateSubject(Subject subject){
        subjectRepository.save(subject);
    }
}
