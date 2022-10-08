package com.example.SpringBootCollegeApp.validations;

import com.example.SpringBootCollegeApp.annotation.SecuredPassword;
import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SecuredPasswordValidator implements ConstraintValidator<SecuredPassword,String> {
    @Override
    public void initialize(SecuredPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                new LengthRule(8, 30),
                new CharacterRule(EnglishCharacterData.UpperCase, 1),
                new CharacterRule(EnglishCharacterData.LowerCase, 1),
                new CharacterRule(EnglishCharacterData.Digit, 1),
                new CharacterRule(EnglishCharacterData.Special, 1),
                new WhitespaceRule()

        ));

        RuleResult result = validator.validate(new PasswordData(password));

        if (result.isValid())
            return true;

        List<String> messages = validator.getMessages(result);

        String errors = messages.stream()
                .collect(Collectors.joining(","));

        context.buildConstraintViolationWithTemplate(errors)
                .addConstraintViolation()
                .disableDefaultConstraintViolation();

        return false;
    }
}
