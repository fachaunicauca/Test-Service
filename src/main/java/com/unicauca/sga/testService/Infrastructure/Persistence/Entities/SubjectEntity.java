package com.unicauca.sga.testService.Infrastructure.Persistence.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Subject")
public class SubjectEntity {
    @Id
    private String subject_name;
}
