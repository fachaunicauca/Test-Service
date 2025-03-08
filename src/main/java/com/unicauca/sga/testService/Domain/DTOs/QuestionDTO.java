package com.unicauca.sga.testService.Domain.DTOs;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {
    private long question_id;
    private String question_title;
    private String question_text;
    private String question_image;
    private int number_of_answers;
    private List<AnswerDTO> answers;
}
