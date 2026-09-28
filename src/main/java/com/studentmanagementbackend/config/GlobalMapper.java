package com.studentmanagementbackend.config;

import com.studentmanagementbackend.dto.CourseRequest;
import com.studentmanagementbackend.dto.CourseResponse;
import com.studentmanagementbackend.dto.StudentResponse;
import com.studentmanagementbackend.dto.StudentRequest;
import com.studentmanagementbackend.entity.Course;
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

    public Student studentMapperReq(StudentRequest studentRequest){
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

    public CourseResponse courseMapperRes(Course course){
        CourseResponse courseResponse = new CourseResponse();
        courseResponse.setId(course.getId());
        courseResponse.setCourseName(course.getCourseName());
        courseResponse.setCourseCode(course.getCourseCode());
        courseResponse.setCourseDuration(course.getCourseDuration());
        return courseResponse;
    }

    public Course courseMapperReq(CourseRequest courseRequest){
        Course course = new Course();
        course.setCourseName(courseRequest.getCourseName());
        course.setCourseCode(courseRequest.getCourseCode());
        course.setCourseDuration(courseRequest.getCourseDuration());
        return course;
    }
}
