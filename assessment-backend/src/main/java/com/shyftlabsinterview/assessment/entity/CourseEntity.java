package com.shyftlabsinterview.assessment.entity;

import com.shyftlabsinterview.assessment.model.request.AddCourseRequestModel;
import jakarta.persistence.*;

// Entity for "course" data schema
@Entity
@Table(name = "course")
public class CourseEntity extends BaseEntity {

    @Column(name = "course_name")
    private String courseName;
    private Boolean isActive = true;

    public CourseEntity() {
    }

    public CourseEntity(AddCourseRequestModel model) {
        this.courseName = model.getCourseName();
    }

    // Getter and Setter
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", isActive=" + isActive +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
