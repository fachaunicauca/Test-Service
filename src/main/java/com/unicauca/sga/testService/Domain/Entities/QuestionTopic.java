package com.unicauca.sga.testService.Domain.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "QuestionTopic")
public class QuestionTopic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_topic_id;

    @Column
    private String qt_description;

}
