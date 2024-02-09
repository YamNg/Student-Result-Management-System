package com.shyftlabsinterview.assessment.entity;


import com.shyftlabsinterview.assessment.model.request.AddStudentRequestModel;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "student")
public class StudentEntity extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "family_name")
    private String familyName;

    @Temporal(TemporalType.DATE)
    private Date dob;

    private String email;

    private Boolean isActive = true;

    public StudentEntity() {
    }

    public StudentEntity(AddStudentRequestModel model) {
        this.firstName = model.getFirstName();
        this.familyName = model.getFamilyName();
        this.dob = model.getDob();
        this.email = model.getEmail();
    }

    // Getter and Setter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "firstName='" + firstName + '\'' +
                ", familyName='" + familyName + '\'' +
                ", dob=" + dob +
                ", email='" + email + '\'' +
                ", isActive=" + isActive +
                ", id=" + id +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
