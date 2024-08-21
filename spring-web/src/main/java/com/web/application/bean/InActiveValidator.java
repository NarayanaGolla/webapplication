package com.web.application.bean;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InActiveValidator implements ConstraintValidator<ValidInActive, Boolean> {

    @Override
    public void initialize(ValidInActive constraintAnnotation) {
    }

    @Override
    public boolean isValid(Boolean inActive, ConstraintValidatorContext context) {
        // Custom validation logic
        // For example, check if inActive is false (could be any business logic)
        return inActive != null && !inActive;
    }
}
