package com.studentmanagementbackend.repository;

import com.studentmanagementbackend.entity.Course;
import com.studentmanagementbackend.entity.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,Long> {
    List<Subject> findAllByCourse(Course course);
}
