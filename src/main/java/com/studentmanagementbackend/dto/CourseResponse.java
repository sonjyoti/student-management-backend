package com.studentmanagementbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseResponse {
    private Long id;
    private String courseName;
    private String courseCode;
    private String courseDuration;
}
