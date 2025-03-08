package com.unicauca.sga.testService.Infrastructure.Persistence.Entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "Test")
public class TestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long test_id;

    @Column
    private Long teacher_id;

    @Column
    private String teacher_name;

    @Column
    private Long student_id;

    @ManyToOne
    @JoinColumn(name = "subject_name", table = "Subject")
    private SubjectEntity subject;

    @Column
    private Date test_date;

    @Column
    private float test_score;
}
