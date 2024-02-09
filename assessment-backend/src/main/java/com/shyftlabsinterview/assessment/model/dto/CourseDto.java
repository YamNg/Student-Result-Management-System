package com.shyftlabsinterview.assessment.model.dto;

import com.shyftlabsinterview.assessment.entity.CourseEntity;

// Dto class for course, used for return targeted data to frontend
public class CourseDto {
    private Long id;
    private String courseName;

    public CourseDto() {
    }

    public CourseDto(CourseEntity entity) {
        this.id = entity.getId();
        this.courseName = entity.getCourseName();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
