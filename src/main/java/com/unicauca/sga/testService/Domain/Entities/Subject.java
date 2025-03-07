package com.unicauca.sga.testService.Domain.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Subject")
public class Subject {
    @Id
    private String subject_name;
}
