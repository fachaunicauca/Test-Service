package com.unicauca.sga.testService.Infrastructure.Persistence.Tables;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "QuestionTopic")
public class QuestionTopicTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int question_topic_id;

    @Column
    private String qt_description;

}
