package com.shyftlabsinterview.assessment.repository;

import com.shyftlabsinterview.assessment.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository class for Student
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {
    // should only query data which isActive = true
    List<StudentEntity> findByIsActiveTrue();
}
