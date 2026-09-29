package com.studentmanagementbackend.controller;

import com.studentmanagementbackend.dto.MarksResponse;
import com.studentmanagementbackend.service.MarksService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/marks")
public class MarksController {

    private final MarksService marksService;

    public MarksController(MarksService marksService) {
        this.marksService = marksService;
    }

    @GetMapping("/student/{studentId}")
    public List<MarksResponse> getMarksByStudent(@PathVariable Long studentId) {
        return marksService.getMarksByStudent(studentId);
    }

    @GetMapping("/subject/{subjectId}")
    public List<MarksResponse> getMarksBySubject(@PathVariable Long subjectId) {
        return marksService.getMarksBySubject(subjectId);
    }
}
