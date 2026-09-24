package com.studentmanagementbackend.repository;

import com.studentmanagementbackend.entity.Marks;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends CrudRepository<Marks,Long> {
}
