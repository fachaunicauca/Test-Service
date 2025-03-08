package com.unicauca.sga.testService.Domain.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class StudentAnswerDTO {
    private long question_id;
    private List<Long> answer_id;
}
