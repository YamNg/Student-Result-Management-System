package com.shyftlabsinterview.assessment.repository;

import com.shyftlabsinterview.assessment.entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository class for Course
public interface CourseRepository extends JpaRepository<CourseEntity, Long> {
    // should only query data which isActive = true
    List<CourseEntity> findByIsActiveTrue();
}
