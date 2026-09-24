package com.studentmanagementbackend.repository;

import com.studentmanagementbackend.dto.Subject;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends CrudRepository<Subject,Long> {
}
