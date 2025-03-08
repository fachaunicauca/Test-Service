package com.unicauca.sga.testService.Domain.DTOs;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class StudentTestResponseDTO {
    private long test_id;
    private Date test_date;
    private long student_code;
    private List<StudentAnswerDTO> student_response;
}
