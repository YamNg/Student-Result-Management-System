package com.shyftlabsinterview.assessment.util.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.Calendar;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// annotation for checking Past date
@Constraint(validatedBy = PastDateValidatorImpl.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface PastDate {
    String message() default "The date must be in the past";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    int calendarField() default Calendar.YEAR;

    int amount() default -1; // Default to 1 years in the past
}
