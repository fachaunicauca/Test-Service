package com.unicauca.sga.testService.Domain.IServices;

import com.unicauca.sga.testService.Domain.Entities.Subject;

import java.util.List;

public interface ISubjectService {
    List<Subject> getAllSubjects();
    Subject getSubjectById(String id);
    void saveSubject(Subject subject);
    void deleteSubject(Subject subject);
    void deleteSubjectById(String id);
    void updateSubject(Subject subject);
}
