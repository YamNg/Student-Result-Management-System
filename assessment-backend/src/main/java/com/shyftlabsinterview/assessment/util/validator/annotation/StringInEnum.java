package com.shyftlabsinterview.assessment.util.validator.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

// annotation for checking if input string in the enum
@Constraint(validatedBy = StringInEnumValidatorImpl.class)
@Target({ FIELD })
@Retention(RUNTIME)
public @interface StringInEnum {

    Class<? extends Enum<?>> enumClass();

    String message() default "Invalid input value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
