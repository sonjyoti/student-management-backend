package com.studentmanagementbackend.controller;

import com.studentmanagementbackend.dto.CourseRequest;
import com.studentmanagementbackend.dto.CourseResponse;
import com.studentmanagementbackend.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseResponse> getAllCourses(){
        return courseService.getAllCourses();
    }

    @GetMapping("/{courseId}")
    public CourseResponse getCourseById(@PathVariable Long courseId){
        return courseService.getCourseById(courseId);
    }

    @PostMapping
    public CourseResponse addCourse(@RequestBody CourseRequest courseRequest){
        return courseService.addCourse(courseRequest);
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
    }
}
