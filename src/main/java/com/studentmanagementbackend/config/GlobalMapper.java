package com.studentmanagementbackend.config;

import com.studentmanagementbackend.dto.*;
import com.studentmanagementbackend.entity.Course;
import com.studentmanagementbackend.entity.Student;
import com.studentmanagementbackend.entity.Subject;
import org.springframework.stereotype.Component;

@Component
public class GlobalMapper {
    public StudentResponse studentMapperResponse(Student student){
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

    public Student studentMapperRequest(StudentRequest studentRequest){
        Student student = new Student();
        student.setFirstName(studentRequest.getFirstName());
        student.setLastName(studentRequest.getLastName());
        student.setEmail(studentRequest.getEmail());
        student.setGender(studentRequest.getGender());
        student.setAddress(studentRequest.getAddress());
        student.setDateOfBirth(studentRequest.getDateOfBirth());
        student.setAdmissionDate(studentRequest.getAdmissionDate());
        student.setDistrict(studentRequest.getDistrict());
        student.setCountry(studentRequest.getCountry());
        student.setRollNo(studentRequest.getRollNo());
        student.setPhoneNumber(studentRequest.getPhoneNumber());
        student.setState(studentRequest.getState());
        return student;
    }

    public CourseResponse courseMapperResponse(Course course){
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(course.getId());
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setCourseCode(course.getCourseCode());
        courseResponse.setCourseDuration(course.getCourseDuration());
        return courseResponse;
    }

    public Course courseMapperRequest(CourseRequest courseRequest){
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setCourseCode(courseRequest.getCourseCode());
        course.setCourseDuration(courseRequest.getCourseDuration());
        return course;
    }

    public SubjectResponse subjectMapperResponse(Subject subject){
        SubjectResponse subjectResponse = new SubjectResponse();
        subjectResponse.setId(subject.getId());
        subjectResponse.setSubjectName(subject.getSubjectName());
        subjectResponse.setSubjectCode(subject.getSubjectCode());
        return subjectResponse;
    }

    public Subject subjectMapperRequest(SubjectRequest subjectRequest){
        Subject subject = new Subject();
        subject.setSubjectName(subjectRequest.getSubjectName());
        subject.setSubjectCode(subjectRequest.getSubjectCode());
        return subject;
    }
}
