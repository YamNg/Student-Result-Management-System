package com.shyftlabsinterview.assessment.model.request;

import com.shyftlabsinterview.assessment.constant.ResultScore;
import com.shyftlabsinterview.assessment.constant.ErrorCode;
import com.shyftlabsinterview.assessment.entity.CourseEntity;
import com.shyftlabsinterview.assessment.entity.StudentEntity;
import com.shyftlabsinterview.assessment.util.validator.annotation.StringInEnum;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// Request Body Model for Adding a Result
public class AddResultRequestModel {
    // Check for studentId, should not be null and smaller than 1
    @NotNull(message = ErrorCode.INVALID_STUDENT_ID)
    @Min(value = 1L, message = ErrorCode.INVALID_STUDENT_ID)
    private Long studentId;
    // Used for storage of reference to student entity when saving the result entity
    private StudentEntity student;

    // Check for courseId, should not be null and smaller than 1
    @NotNull(message = ErrorCode.INVALID_COURSE_ID)
    @Min(value = 1L, message = ErrorCode.INVALID_COURSE_ID)
    private Long courseId;

    // Used for storage of reference to course entity when saving the result entity
    private CourseEntity course;

    // Check for sore, should not be blank and value should be defined in enum
    @NotBlank(message = ErrorCode.INVALID_RESULT_SCORE)
    @StringInEnum(enumClass = ResultScore.class, message = ErrorCode.INVALID_RESULT_SCORE)
    private String score;

    public AddResultRequestModel() {
    }

    public AddResultRequestModel(Long studentId, Long courseId, String score) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.score = score;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public StudentEntity getStudent() {
        return student;
    }

    public void setStudent(StudentEntity student) {
        this.student = student;
    }

    public CourseEntity getCourse() {
        return course;
    }

    public void setCourse(CourseEntity course) {
        this.course = course;
    }
}
