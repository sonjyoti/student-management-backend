package com.studentmanagementbackend.dto;

import com.studentmanagementbackend.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectResponse {
    private Long id;

    private String subjectName;
    private String subjectCode;
    private int semester;
    private int credit;

    private Course course;
}
