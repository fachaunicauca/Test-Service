package com.unicauca.sga.testService.Infrastructure.Persistence.Tables;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Question")
public class QuestionTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_id;

    @ManyToOne
    @JoinColumn(name = "question_topic_id", table = "QuestionTopic")
    private QuestionTopicTable questionTopic;

    @ManyToOne
    @JoinColumn(name = "subject_name", table = "Subject", nullable = false)
    private SubjectTable subject;

    @Column
    private String question_title;

    @Column
    private String question_text;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private String question_image;

}
