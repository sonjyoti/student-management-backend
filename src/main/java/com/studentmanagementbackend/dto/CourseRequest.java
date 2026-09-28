package com.studentmanagementbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CourseRequest {
    private String courseName;
    private String courseCode;
    private String courseDuration;
}
