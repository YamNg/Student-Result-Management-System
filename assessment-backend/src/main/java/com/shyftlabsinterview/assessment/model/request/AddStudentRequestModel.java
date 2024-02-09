package com.shyftlabsinterview.assessment.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.OptBoolean;
import com.shyftlabsinterview.assessment.constant.ErrorCode;
import com.shyftlabsinterview.assessment.util.validator.annotation.PastDate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Calendar;
import java.util.Date;

public class AddStudentRequestModel {
    // Check for firstName, should not be blank
    @NotBlank(message = ErrorCode.INVALID_STUDENT_FIRSTNAME)
    private String firstName;

    @NotBlank(message = ErrorCode.INVALID_STUDENT_FAMILYNAME)
    private String familyName;

    // Check for dob, should not be null and in format of "yyyy-MM-dd"
    // as well as the date should be at lease 10 years ago from now
    @NotNull(message = ErrorCode.INVALID_STUDENT_DOB)
    @PastDate(calendarField = Calendar.YEAR, amount = 10, message = ErrorCode.INVALID_STUDENT_DOB)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", lenient = OptBoolean.FALSE)
    private Date dob;

    // Check for email, should not be blank and with defined format
    // using @Email hibernate validator to do the primary check of email format
    // as well as an addition regex ".+@.+\\..+" for preventing email without top level domain (i.e. @Email will permit email like w@goo)
    @NotBlank(message = ErrorCode.INVALID_STUDENT_EMAIL)
    @Email(regexp = ".+@.+\\..+", message = ErrorCode.INVALID_STUDENT_EMAIL)
    private String email;

    public AddStudentRequestModel() {
    }

    public AddStudentRequestModel(String firstName, String familyName, Date dob, String email) {
        this.firstName = firstName;
        this.familyName = familyName;
        this.dob = dob;
        this.email = email;
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
