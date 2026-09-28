package com.studentmanagementbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class StudentResponse {
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
    private Long courseId;
    private String courseName;
}
