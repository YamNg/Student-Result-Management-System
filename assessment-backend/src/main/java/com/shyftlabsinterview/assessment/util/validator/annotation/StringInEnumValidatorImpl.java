package com.shyftlabsinterview.assessment.util.validator.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class StringInEnumValidatorImpl implements ConstraintValidator<StringInEnum, String> {

    List<String> enumValueList = null;

    @Override
    public void initialize(StringInEnum constraintAnnotation) {
        // find enum value list by class passed as parameter
        enumValueList = new ArrayList<String>();
        Class<? extends Enum<?>> enumClass = constraintAnnotation.enumClass();

        Enum<?>[] values = enumClass.getEnumConstants();

        for (Enum<?> value : values) {
            enumValueList.add(value.toString().toUpperCase());
        }
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // check if the input value contains in enum
        return enumValueList.contains(value.toUpperCase());
    }

}
