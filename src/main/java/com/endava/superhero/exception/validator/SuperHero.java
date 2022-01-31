package com.endava.superhero.exception.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = com.endava.superhero.exception.validator.SuperHeroValidator.class)
@Documented
public @interface SuperHero {

    String message() default "Not a valid hero email.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
