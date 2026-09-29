package com.studentmanagementbackend.repository;

import com.studentmanagementbackend.entity.Marks;
import com.studentmanagementbackend.entity.Student;
import com.studentmanagementbackend.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarksRepository extends CrudRepository<Marks,Long> {
    List<Marks> findAllByStudent(Student student);

    List<Marks> findAllBySubject(Subject subject);
}
