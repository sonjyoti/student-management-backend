package com.studentmanagementbackend.service;

import com.studentmanagementbackend.config.GlobalMapper;
import com.studentmanagementbackend.dto.CourseRequest;
import com.studentmanagementbackend.dto.CourseResponse;
import com.studentmanagementbackend.entity.Course;

import com.studentmanagementbackend.repository.CourseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;
    private final GlobalMapper globalMapper;

    public CourseService(CourseRepository courseRepository, GlobalMapper globalMapper) {
        this.courseRepository = courseRepository;
        this.globalMapper = globalMapper;
    }

    public List<CourseResponse> getAllCourses() {
        Iterable<Course> courses = courseRepository.findAll();
        List<CourseResponse> courseResponses = new ArrayList<>();
        for (Course course : courses) {
            CourseResponse courseResponse = globalMapper.courseMapperResponse(course);
            courseResponses.add(courseResponse);
        }
        return courseResponses;
    }

    public CourseResponse getCourseById(Long id){
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found with id: " + id
                )
        );
        return globalMapper.courseMapperResponse(course);
    }

    public CourseResponse addCourse(CourseRequest courseRequest){
        Course course = globalMapper.courseMapperRequest(courseRequest);
        Course newCourse = courseRepository.save(course);
        return globalMapper.courseMapperResponse(newCourse);
    }

    public void deleteCourse(Long id){
        Course course = courseRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with id: " + id
                )
        );
        courseRepository.delete(course);
        globalMapper.courseMapperResponse(course);
    }
}
