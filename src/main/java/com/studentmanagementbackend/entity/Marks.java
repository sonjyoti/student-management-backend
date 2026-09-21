package com.studentmanagementbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Marks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int mark;

    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;
}
