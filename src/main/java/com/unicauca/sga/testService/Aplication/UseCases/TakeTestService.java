package com.unicauca.sga.testService.Aplication.UseCases;

import com.unicauca.sga.testService.Aplication.Mappers.QuestionListDTOMapper;
import com.unicauca.sga.testService.Domain.Model.Answer;
import com.unicauca.sga.testService.Domain.Model.DTOs.QuestionListDTO;
import com.unicauca.sga.testService.Domain.Model.DTOs.StudentAnswerDTO;
import com.unicauca.sga.testService.Domain.Model.DTOs.StudentTestResponseDTO;
import com.unicauca.sga.testService.Domain.Model.Question;
import com.unicauca.sga.testService.Domain.Model.Subject;
import com.unicauca.sga.testService.Domain.Model.Test;
import com.unicauca.sga.testService.Domain.Ports.Services.IAnswerService;
import com.unicauca.sga.testService.Domain.Ports.Services.IQuestionService;
import com.unicauca.sga.testService.Domain.Ports.Services.ISubjectService;
import com.unicauca.sga.testService.Domain.Ports.Services.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
     * are returned. If the data is invalid, an exception is sent.
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
        newTest.setNum_of_questions(n);
        testService.saveTest(newTest);
        //Get and return the Questions (Not random)
        List<Question> questionList = questionService.getRandomQuestionsBySubject(subject_name, n);
        return questionListDTOMapper.toDTO(newTest.getTest_id(), questionList);
    }

    public float saveTest(StudentTestResponseDTO studentTestResponseDTO){
        //Validate that the test has been created before
        if(!testService.isPresent(studentTestResponseDTO.getTest_id())){
            throw new IllegalArgumentException("El test con id "+
                                                studentTestResponseDTO.getTest_id()+
                                                " no ha sido creado.");
        }
        Test test = testService.getTestById(studentTestResponseDTO.getTest_id());
        //Validate that the student code is correct
        if(!(test.getStudent_id() ==studentTestResponseDTO.getStudent_code())){
            throw new IllegalArgumentException("El codigo del estudiante "+
                                                studentTestResponseDTO.getTest_id()+
                                                " no corresponde al test.");
        }
        //Validate that the student answered all the questions
        if(!(studentTestResponseDTO.getStudent_response().size() == test.getNum_of_questions())){
            throw new IllegalArgumentException("El test no está completo. Se esperaban "+
                                                test.getNum_of_questions()+
                                                " preguntas respondidas.");
        }
        //Score the test
        float test_score = scoreTest(studentTestResponseDTO,test.getNum_of_questions());
        //Update the test
        test.setTest_date(studentTestResponseDTO.getTest_date());
        test.setTest_score(test_score);
        testService.updateTest(test);
        //Send the test score
        return test_score;
    }

    private float scoreTest(StudentTestResponseDTO studentTestResponseDTO, int num_of_questions){
        int correctAnswersCount = 0;
        boolean isCorrect;
        for(StudentAnswerDTO studentAnswerDTO: studentTestResponseDTO.getStudent_response()){
            //If answer id is a list, it means that there are multiple answers
            if(studentAnswerDTO.getAnswer_id().size()!=1) {
                List<Long> student_answers = studentAnswerDTO.getAnswer_id();
                //Get all the question answers
                List<Answer> answers = answerService.getAllAnswersByQuestion(studentAnswerDTO.getQuestion_id());
                //Get the correct answers
                List<Long> correct_answers = answers.stream()
                        .filter(Answer::isAnswer_isCorrect)
                        .map(Answer::getAnswer_id)
                        .toList();
                //If the list are the same it means that the answers are correct
                if (correct_answers.size() == student_answers.size()) {
                    //Ignore the order
                    Set<Long> correctSet = new HashSet<>(correct_answers);
                    Set<Long> studentSet = new HashSet<>(student_answers);

                    if (correctSet.equals(studentSet)) correctAnswersCount++;
                }
            }else{
                isCorrect=answerService.getAnswerById(studentAnswerDTO.getAnswer_id().get(0)).isAnswer_isCorrect();
                if(isCorrect) correctAnswersCount++;
            }
        }
        return (float) correctAnswersCount / num_of_questions;
    }
}
