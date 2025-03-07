package com.unicauca.sga.testService.Domain.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long test_id;

    @Column
    private String teacher_id;

    @Column
    private String student_code;

    @Column
    private Date test_date;

    @Column
    private float test_score;
}
