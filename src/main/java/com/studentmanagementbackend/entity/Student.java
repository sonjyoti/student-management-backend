package com.studentmanagementbackend.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
}
