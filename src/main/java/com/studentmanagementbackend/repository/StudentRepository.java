package com.studentmanagementbackend.repository;

import com.studentmanagementbackend.dto.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student,Long> {
}
