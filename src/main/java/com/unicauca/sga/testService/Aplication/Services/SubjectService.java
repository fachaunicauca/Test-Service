package com.unicauca.sga.testService.Aplication.Services;

import com.unicauca.sga.testService.Domain.Model.Subject;
import com.unicauca.sga.testService.Domain.Ports.Repositories.ISubjectRepository;
import com.unicauca.sga.testService.Domain.Ports.Services.ISubjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService implements ISubjectService {

    private ISubjectRepository subjectRepository;

    public SubjectService(ISubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> getAllSubjects(){
        return (List<Subject>) subjectRepository.findAll();
    }

    public Subject getSubjectById(String id){
        return subjectRepository.findById(id);
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
