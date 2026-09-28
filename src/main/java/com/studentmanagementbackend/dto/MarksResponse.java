package com.studentmanagementbackend.dto;

import com.studentmanagementbackend.entity.Student;
import com.studentmanagementbackend.entity.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MarksResponse {
    private Long id;
    private int mark;
    private Subject subject;
    private Student student;
}
