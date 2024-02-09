package com.shyftlabsinterview.assessment.model.dto;

import com.shyftlabsinterview.assessment.constant.ResultScore;
import com.shyftlabsinterview.assessment.entity.ResultEntity;

// Dto class for result, used for return targeted data to frontend
public class ResultDto {
    private Long id;
    private StudentDto student;
    private CourseDto course;
    private ResultScore score;

    public ResultDto() {
    }

    public ResultDto(ResultEntity entity) {
        this.id = entity.getId();
        this.student = new StudentDto(entity.getStudent());
        this.course = new CourseDto(entity.getCourse());
        this.score = entity.getScore();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentDto getStudent() {
        return student;
    }

    public void setStudent(StudentDto student) {
        this.student = student;
    }

    public CourseDto getCourse() {
        return course;
    }

    public void setCourse(CourseDto course) {
        this.course = course;
    }

    public ResultScore getScore() {
        return score;
    }

    public void setScore(ResultScore score) {
        this.score = score;
    }
}
