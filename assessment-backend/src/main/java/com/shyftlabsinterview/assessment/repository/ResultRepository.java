package com.shyftlabsinterview.assessment.repository;

import com.shyftlabsinterview.assessment.entity.ResultEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// Repository class for Result
public interface ResultRepository extends JpaRepository<ResultEntity, Long> {
    // should only query Student and Course data which isActive = true
    List<ResultEntity> findByStudentIsActiveTrueAndCourseIsActiveTrue();
}
