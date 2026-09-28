package com.studentmanagementbackend.controller;

import com.studentmanagementbackend.dto.SubjectRequest;
import com.studentmanagementbackend.dto.SubjectResponse;
import com.studentmanagementbackend.service.SubjectService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/{subjectId}")
    public SubjectResponse getSubjectById(@PathVariable Long subjectId) {
        return subjectService.getSubjectById(subjectId);
    }

    @GetMapping("/course/{courseId}")
    public List<SubjectResponse> getAllSubjectsByCourse(@PathVariable Long courseId) {
        return subjectService.getSubjectsByCourse(courseId);
    }

    @PostMapping
    public SubjectResponse addSubject(@RequestBody SubjectRequest subjectRequest) {
        return subjectService.addSubject(subjectRequest);
    }

    @DeleteMapping("/{subjectId}")
    public void deleteSubject(@PathVariable Long subjectId) {
        subjectService.deleteSubject(subjectId);
    }
}
