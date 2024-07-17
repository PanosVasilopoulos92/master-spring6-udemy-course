package org.viators.practice_project16.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.viators.practice_project16.annotation.PasswordStrength;

import java.util.Arrays;
import java.util.List;

public class PasswordStrengthValidator implements ConstraintValidator<PasswordStrength, String> {

    private List<String> weakPasswords;

    @Override
    public void initialize(PasswordStrength constraintAnnotation) {
        weakPasswords = Arrays.asList("12345", "qwert", "asdfg"); // Examples of weak passwords.
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value != null && (!weakPasswords.contains(value));
    }
}
