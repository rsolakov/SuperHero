package com.endava.superhero.exception.validator;

import com.endava.superhero.dto.SuperHeroDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SuperHeroValidator implements ConstraintValidator<SuperHero, String> {


    @Override
    public void initialize(SuperHero constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return false;
    }
}
