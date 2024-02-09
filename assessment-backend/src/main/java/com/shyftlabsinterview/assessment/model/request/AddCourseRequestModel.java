package com.shyftlabsinterview.assessment.model.request;

import com.shyftlabsinterview.assessment.constant.ErrorCode;
import jakarta.validation.constraints.NotBlank;

// Request Body Model for Adding a Course
public class AddCourseRequestModel {

    // Check for courseName, should not be blank
    @NotBlank(message = ErrorCode.INVALID_COURSE_NAME)
    private String courseName;

    public AddCourseRequestModel(){}

    public AddCourseRequestModel(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
