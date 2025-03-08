package com.unicauca.sga.testService.Domain.Model;

import lombok.Data;

import java.util.Date;

@Data
public class Test {
    private Long test_id;
    private Long teacher_id;
    private String teacher_name;
    private Long student_id;
    private Subject subject;
    private Date test_date;
    private float test_score;
}
