package com.studentmanagementbackend.service;

import com.studentmanagementbackend.config.GlobalMapper;
import com.studentmanagementbackend.dto.StudentResponse;
import com.studentmanagementbackend.dto.StudentRequest;
import com.studentmanagementbackend.entity.Course;
import com.studentmanagementbackend.entity.Student;
import com.studentmanagementbackend.repository.CourseRepository;
import com.studentmanagementbackend.repository.StudentRepository;

import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final GlobalMapper globalMapper;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository, GlobalMapper globalMapper) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.globalMapper = globalMapper;
    }

    public StudentResponse getStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with id: " + id
                )
        );
        return globalMapper.studentMapperResponse(student);
    }

    public List<StudentResponse> getAllStudentsByCourseId(Long courseId){
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with id: " + courseId
                )
        );
        List<Student> studentList = studentRepository.findAllByCourse(course);
        List<StudentResponse> StudentResponseList = new ArrayList<>();
        for (Student student : studentList) {
            StudentResponseList.add(globalMapper.studentMapperResponse(student));
        }
        return StudentResponseList;
    }

    public List<StudentResponse> getAllStudents(){
        Iterable<Student> studentList = studentRepository.findAll();
        List<StudentResponse> StudentResponseList = new ArrayList<>();
        for (Student student : studentList) {
            StudentResponse StudentResponse = globalMapper.studentMapperResponse(student);
            StudentResponseList.add(StudentResponse);
        }
        return StudentResponseList;
    }

    @Transactional
    public StudentResponse addStudent(StudentRequest studentRequest){
        Course course = courseRepository.findById(studentRequest.getCourseId()).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with id: " + studentRequest.getCourseId()
                )
        );
        Student student = globalMapper.studentMapperRequest(studentRequest);
        student.setCourse(course);
        Student newStudent = studentRepository.save(student);
        return globalMapper.studentMapperResponse(newStudent);
    }

    public void deleteStudentById(Long id){
        Student student = studentRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with id: " + id
                )
        );
        studentRepository.delete(student);
        globalMapper.studentMapperResponse(student);
    }
}
