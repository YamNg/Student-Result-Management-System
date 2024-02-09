package com.shyftlabsinterview.assessment.entity;

import com.shyftlabsinterview.assessment.constant.ResultScore;
import com.shyftlabsinterview.assessment.model.request.AddResultRequestModel;
import jakarta.persistence.*;

// Entity for "result" data schema
// Declared a unique constraint to prevent user input for duplicate "student - course" entry
@Entity
@Table(name = "result", uniqueConstraints = @UniqueConstraint(columnNames = {"studentId", "courseId"}))
public class ResultEntity extends BaseEntity {
    // always fetching (i.e. "FetchType.EAGER") for student and course
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "studentId", referencedColumnName = "id")
    private StudentEntity student;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "courseId", referencedColumnName = "id")
    private CourseEntity course;

    // use enum for score
    @Enumerated(EnumType.STRING)
    private ResultScore score;

    public ResultEntity() {
    }

    public ResultEntity(AddResultRequestModel model) {
        this.student = model.getStudent();
        this.course = model.getCourse();
        this.score = ResultScore.valueOf(model.getScore());
    }

    // Getter and Setter
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

    public ResultScore getScore() {
        return score;
    }

    public void setScore(ResultScore score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "id=" + id +
                ", student=" + student +
                ", course=" + course +
                ", score=" + score +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
