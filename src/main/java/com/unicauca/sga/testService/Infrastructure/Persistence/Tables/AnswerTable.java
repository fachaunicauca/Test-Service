package com.unicauca.sga.testService.Infrastructure.Persistence.Tables;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Answer")
public class AnswerTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;

    @ManyToOne
    @JoinColumn(name = "question_id", table = "Question", nullable = false)
    private Long question_id;

    @Column
    private String answer_text;

    @Column
    private boolean answer_isCorrect;
}
