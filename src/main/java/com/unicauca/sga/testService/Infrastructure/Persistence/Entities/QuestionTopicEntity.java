package com.unicauca.sga.testService.Infrastructure.Persistence.Entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "QuestionTopic")
public class QuestionTopicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_topic_id;

    @Column
    private String qt_description;

}
