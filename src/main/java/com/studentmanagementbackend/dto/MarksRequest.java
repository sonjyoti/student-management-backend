package com.studentmanagementbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MarksRequest {
    private int mark;
    private Long subjectId;
    private Long studentId;
}
