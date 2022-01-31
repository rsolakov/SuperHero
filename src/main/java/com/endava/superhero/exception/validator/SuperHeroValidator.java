package com.endava.superhero.exception.validator;

import com.endava.superhero.service.SuperHeroService;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class SuperHeroValidator implements ConstraintValidator<SuperHeroName, String> {

    private final SuperHeroService superHeroService;

    public SuperHeroValidator(SuperHeroService superHeroService) {
        this.superHeroService = superHeroService;
    }


    @Override
    public boolean isValid(String SuperHeroName, ConstraintValidatorContext context) {
        if (SuperHeroName == null) {
            return true;
        }
        return superHeroService.isNameUnique(SuperHeroName);
    }
}
