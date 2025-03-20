package com.unicauca.sga.testService.Infrastructure.Controllers;

import com.unicauca.sga.testService.Aplication.UseCases.TakeTestService;
import com.unicauca.sga.testService.Domain.Model.DTOs.QuestionListDTO;
import com.unicauca.sga.testService.Domain.Model.DTOs.StudentTestResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/takeTest")
public class TakeTestController {

    private final TakeTestService takeTestService;
    @Value("${config.questions.quantity}")
    private int n;

    public TakeTestController(TakeTestService takeTestService){
        this.takeTestService=takeTestService;
    }

    @GetMapping
    public QuestionListDTO getTestQuestions(@RequestParam("subject_name") String subject_name,
                                                 @RequestParam("student_code")Long student_code,
                                                 @RequestParam("teacher_name") String teacher_name){
        return takeTestService.getTestQuestions(subject_name,student_code,teacher_name, n);
    }

    @PostMapping
    public float saveAndScoreTest(@RequestBody StudentTestResponseDTO studentTestResponseDTO){
        return takeTestService.saveTest(studentTestResponseDTO);
    }

}
