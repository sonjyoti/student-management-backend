package com.studentmanagementbackend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subjectName;
    private String subjectCode;
    private int semester;
    private int credit;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,  optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;
}
