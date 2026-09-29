package com.studentmanagementbackend.service;

import com.studentmanagementbackend.config.GlobalMapper;
import com.studentmanagementbackend.dto.MarksResponse;
import com.studentmanagementbackend.entity.Marks;
import com.studentmanagementbackend.entity.Student;
import com.studentmanagementbackend.entity.Subject;
import com.studentmanagementbackend.repository.MarksRepository;
import com.studentmanagementbackend.repository.StudentRepository;
import com.studentmanagementbackend.repository.SubjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class MarksService {

    private final MarksRepository marksRepository;
    private final StudentRepository studentRepository;
    private final SubjectRepository subjectRepository;
    private final GlobalMapper globalMapper;

    public MarksService(MarksRepository marksRepository, StudentRepository studentRepository, SubjectRepository subjectRepository, GlobalMapper globalMapper) {
        this.marksRepository = marksRepository;
        this.studentRepository = studentRepository;
        this.subjectRepository = subjectRepository;
        this.globalMapper = globalMapper;
    }

    public List<MarksResponse> getMarksByStudent(Long studentId){

        Student student = studentRepository.findById(studentId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with id " + studentId
                )
        );

        List<Marks> marksList = marksRepository.findAllByStudent(student);
        List<MarksResponse> marksResponseList = new ArrayList<>();
        for (Marks marks : marksList) {
            MarksResponse marksResponse = globalMapper.marksMapperResponse(marks);
            marksResponseList.add(marksResponse);
        }
        return marksResponseList;
    }

    public List<MarksResponse> getMarksBySubject(Long subjectId){

        Subject subject = subjectRepository.findById(subjectId).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Student not found with id " + subjectId
                )
        );

        List<Marks> marksList = marksRepository.findAllBySubject(subject);
        List<MarksResponse> marksResponseList = new ArrayList<>();
        for (Marks marks : marksList) {
            MarksResponse marksResponse = globalMapper.marksMapperResponse(marks);
            marksResponseList.add(marksResponse);
        }
        return marksResponseList;
    }
}
