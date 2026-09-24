package com.studentmanagementbackend.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@Data
@RequiredArgsConstructor
public class StudentRequest {
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
}
