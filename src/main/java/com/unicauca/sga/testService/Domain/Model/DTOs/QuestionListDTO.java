package com.unicauca.sga.testService.Domain.Model.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class QuestionListDTO {
    private long test_id;
    private short number_of_questions;
    private List<QuestionDTO> question;
}
