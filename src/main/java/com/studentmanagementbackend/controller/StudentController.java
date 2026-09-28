package com.studentmanagementbackend.controller;

import com.studentmanagementbackend.dto.StudentRequest;
import com.studentmanagementbackend.dto.StudentResponse;
import com.studentmanagementbackend.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public StudentResponse getStudentById(@PathVariable Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @GetMapping
    public List<StudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/course/{courseId}")
    public List<StudentResponse> getAllStudentsByCourse(@PathVariable Long courseId) {
        return studentService.getAllStudentsByCourseId(courseId);
    }

    @PostMapping
    public StudentResponse addStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.addStudent(studentRequest);
    }

    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudentById(studentId);
    }
}
