package com.studentmanagementbackend.config;

import com.studentmanagementbackend.dto.StudentResponse;
import com.studentmanagementbackend.dto.StudentRequest;
import com.studentmanagementbackend.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class GlobalMapper {
    public StudentResponse studentMapperRes(Student student){
        StudentResponse StudentResponse = new StudentResponse();
        StudentResponse.setId(student.getId());
        StudentResponse.setFirstName(student.getFirstName());
        StudentResponse.setLastName(student.getLastName());
        StudentResponse.setEmail(student.getEmail());
        StudentResponse.setGender(student.getGender());
        StudentResponse.setAddress(student.getAddress());
        StudentResponse.setDateOfBirth(student.getDateOfBirth());
        StudentResponse.setAdmissionDate(student.getAdmissionDate());
        StudentResponse.setDistrict(student.getDistrict());
        StudentResponse.setCountry(student.getCountry());
        StudentResponse.setRollNo(student.getRollNo());
        StudentResponse.setPhoneNumber(student.getPhoneNumber());
        StudentResponse.setState(student.getState());
        StudentResponse.setCourseId(student.getCourse().getId());
        StudentResponse.setCourseName(student.getCourse().getCourseName());
        return StudentResponse;
    }

    public Student studentMapperReq(StudentRequest StudentResponseReq){
        Student student = new Student();
        student.setFirstName(StudentResponseReq.getFirstName());
        student.setLastName(StudentResponseReq.getLastName());
        student.setEmail(StudentResponseReq.getEmail());
        student.setGender(StudentResponseReq.getGender());
        student.setAddress(StudentResponseReq.getAddress());
        student.setDateOfBirth(StudentResponseReq.getDateOfBirth());
        student.setAdmissionDate(StudentResponseReq.getAdmissionDate());
        student.setDistrict(StudentResponseReq.getDistrict());
        student.setCountry(StudentResponseReq.getCountry());
        student.setRollNo(StudentResponseReq.getRollNo());
        student.setPhoneNumber(StudentResponseReq.getPhoneNumber());
        student.setState(StudentResponseReq.getState());
        return student;
    }
}
