package com.studentmanagementbackend.service;

import com.studentmanagementbackend.config.GlobalMapper;
import com.studentmanagementbackend.dto.SubjectRequest;
import com.studentmanagementbackend.dto.SubjectResponse;
import com.studentmanagementbackend.entity.Course;
import com.studentmanagementbackend.entity.Subject;
import com.studentmanagementbackend.repository.CourseRepository;
import com.studentmanagementbackend.repository.SubjectRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final CourseRepository courseRepository;
    private final GlobalMapper globalMapper;

    public SubjectService(SubjectRepository subjectRepository, GlobalMapper globalMapper, CourseRepository courseRepository) {
        this.subjectRepository = subjectRepository;
        this.courseRepository = courseRepository;
        this.globalMapper = globalMapper;
    }

    public SubjectResponse getSubjectById(Long subjectId) {
        Subject subject = subjectRepository.findById(subjectId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found with id: " + subjectId
                )
        );

        SubjectResponse subjectResponse = globalMapper.subjectMapperResponse(subject);
        subjectResponse.setCourseId(subject.getCourse().getId());
        subjectResponse.setCourseName(subject.getCourse().getCourseName());
        subjectResponse.setCourseCode(subject.getCourse().getCourseCode());

        return subjectResponse;
    }

    public List<SubjectResponse> getSubjectsByCourse(Long courseId) {
        Course course = courseRepository.findById(courseId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found with id: " + courseId
                )
        );

        List<Subject> subjectList = subjectRepository.findAllByCourse(course);

        List<SubjectResponse> subjectResponseList = new ArrayList<>();
        for (Subject subject : subjectList) {
            SubjectResponse subjectResponse = globalMapper.subjectMapperResponse(subject);
            subjectResponseList.add(subjectResponse);
        }
        return subjectResponseList;
    }

    @Transactional
    public SubjectResponse addSubject(SubjectRequest subjectRequest) {
        Subject subject = globalMapper.subjectMapperRequest(subjectRequest);
        Course course = courseRepository.findById(subjectRequest.getCourseId()).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Course not found with id: " + subjectRequest.getCourseId()
                )
        );

        subject.setCourse(course);
        subjectRepository.save(subject);
        return globalMapper.subjectMapperResponse(subject);
    }

    public void deleteSubject(Long subjectId) {
        Subject subject  = subjectRepository.findById(subjectId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with id: " + subjectId
                )
        );
        subjectRepository.deleteById(subjectId);
        globalMapper.subjectMapperResponse(subject);
    }
}
