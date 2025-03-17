package com.unicauca.sga.testService.Aplication.UseCases;

import com.unicauca.sga.testService.Aplication.Mappers.QuestionListDTOMapper;
import com.unicauca.sga.testService.Domain.Model.DTOs.QuestionListDTO;
import com.unicauca.sga.testService.Domain.Model.Question;
import com.unicauca.sga.testService.Domain.Model.Subject;
import com.unicauca.sga.testService.Domain.Model.Test;
import com.unicauca.sga.testService.Domain.Ports.Services.IAnswerService;
import com.unicauca.sga.testService.Domain.Ports.Services.IQuestionService;
import com.unicauca.sga.testService.Domain.Ports.Services.ISubjectService;
import com.unicauca.sga.testService.Domain.Ports.Services.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TakeTestService {

    private final QuestionListDTOMapper questionListDTOMapper;

    private final IQuestionService questionService;
    private final IAnswerService answerService;
    private final ISubjectService subjectService;
    private final ITestService testService;

    @Autowired
    public TakeTestService(QuestionListDTOMapper questionListDTOMapper,
                           IQuestionService questionService,
                           IAnswerService answerService,
                           ISubjectService subjectService,
                           ITestService testService) {
        this.questionListDTOMapper=questionListDTOMapper;
        this.questionService = questionService;
        this.answerService=answerService;
        this.subjectService=subjectService;
        this.testService=testService;
    }

    /*
     * First, the user sends the data to validate that he can present
     * the evaluation. Once, the data is validated, the exam questions
     * are returned. If the data is invalid, a null QuestionList is sent.
     */
    public QuestionListDTO getTestQuestions(String subject_name,
                                            Long student_code,
                                            String teacher_name,
                                            int n){
        //Validate that the teacher exists. Teachers Microservice call
        //Validate that the student code exists. Teachers Microservice call
        //Validate that the subject exists.
        if(!subjectService.isPresent(subject_name)){
            return null; //TODO Exception
        }
        Subject subject = subjectService.getSubjectById(subject_name);
        //Create a new test
        Test newTest = new Test();
        newTest.setTeacher_name(teacher_name);
        newTest.setStudent_id(student_code);
        newTest.setSubject(subject);
        testService.saveTest(newTest);
        //Get and return the Questions (Not random)
        List<Question> questionList = questionService.getRandomQuestionsBySubject(subject_name, n);
        return questionListDTOMapper.toDTO(newTest.getTest_id(), questionList);
    }
}
