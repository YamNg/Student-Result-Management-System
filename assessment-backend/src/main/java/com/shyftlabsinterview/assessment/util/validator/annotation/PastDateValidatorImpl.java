package com.shyftlabsinterview.assessment.util.validator.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Calendar;
import java.util.Date;

// implementation for annotation PastDate
public class PastDateValidatorImpl implements ConstraintValidator<PastDate, Date> {
    private int calendarField;
    private int amount;

    @Override
    public void initialize(PastDate constraintAnnotation) {
        this.calendarField = constraintAnnotation.calendarField();
        this.amount = constraintAnnotation.amount();
    }

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        // construct the target date and do the comparison
        Calendar calendar = Calendar.getInstance();
        calendar.add(calendarField, -amount);

        return value.before(calendar.getTime());
    }
}
