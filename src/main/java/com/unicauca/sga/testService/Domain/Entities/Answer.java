package com.unicauca.sga.testService.Domain.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Answer")
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;

    @ManyToOne
    @JoinColumn(name = "question_id", table = "Question")
    private Question question;

    @Column
    private String answer_text;

    @Column
    private boolean answer_isCorrect;
}
