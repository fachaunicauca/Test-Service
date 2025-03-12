package com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.Adapters;

import com.unicauca.sga.testService.Domain.Model.Subject;
import com.unicauca.sga.testService.Domain.Ports.Repositories.ISubjectRepository;
import com.unicauca.sga.testService.Infrastructure.Persistence.Repositories.SubjectJpaRepository;

import java.util.List;

public class SubjectRepository implements ISubjectRepository {
    private final SubjectJpaRepository subjectJpaRepository;

    public SubjectRepository (SubjectJpaRepository subjectJpaRepository){
        this.subjectJpaRepository=subjectJpaRepository;
    }

    @Override
    public List<Subject> findAll() {
        return subjectJpaRepository.findAll();
    }

    @Override
    public Subject findById(String id) {
        return subjectJpaRepository.findById(id).get();
    }

    @Override
    public void save(Subject subject) {
        subjectJpaRepository.save(subject);
    }

    @Override
    public void delete(Subject subject) {
        subjectJpaRepository.delete(subject);
    }

    @Override
    public void deleteById(String id) {
        subjectJpaRepository.deleteById(id);
    }
}
