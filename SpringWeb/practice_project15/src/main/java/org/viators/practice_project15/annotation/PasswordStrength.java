package org.viators.practice_project15.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import org.viators.practice_project15.validations.PasswordStrengthValidator;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = PasswordStrengthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PasswordStrength {
    String message() default "Please choose a strong password";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
