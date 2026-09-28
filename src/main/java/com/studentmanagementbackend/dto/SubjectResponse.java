package com.studentmanagementbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectResponse {
    private Long id;

    private String subjectName;
    private String subjectCode;
    private int semester;
    private int credit;

    private Long courseId;
    private String courseName;
    private String courseCode;
}
