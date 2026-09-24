package com.studentmanagementbackend.dto;

import com.studentmanagementbackend.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String rollNo;
    private String password;
    private Date admissionDate;
    private Date dateOfBirth;
    private String gender;
    private String email;
    private String phoneNumber;
    private String address;
    private String district;
    private String state;
    private String country;
    private String pinCode;
    private Course course;
}
