package com.shyftlabsinterview.assessment.model.dto;

import com.shyftlabsinterview.assessment.entity.StudentEntity;

import java.util.Date;

// Dto class for student, used for return targeted data to frontend
public class StudentDto {
    private Long id;
    private String firstName;
    private String familyName;
    private Date dob;
    private String email;

    public StudentDto() {
    }

    public StudentDto(StudentEntity entity) {
        this.id = entity.getId();
        this.firstName = entity.getFirstName();
        this.familyName = entity.getFamilyName();
        this.dob = entity.getDob();
        this.email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
}
