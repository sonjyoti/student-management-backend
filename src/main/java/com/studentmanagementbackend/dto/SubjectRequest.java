package com.studentmanagementbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SubjectRequest {
    private String subjectName;
    private String subjectCode;
    private int semester;
    private int credit;
    private Long courseId;
}
