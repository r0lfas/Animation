package com.example.demo.validator;

import com.example.demo.model.Animation;
import com.example.demo.model.User;
import com.example.demo.service.AnimationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Pattern;

public class FormValidator implements Validator {
    private static final Pattern NAME_REGEX =
            Pattern.compile("^[a-zA-Z]$");
    private static final Pattern GENRE_REGEX =
            Pattern.compile("^[a-zA-Z]$");
    @Autowired
    private AnimationService animationService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Animation animation = (Animation) o;


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (animation.getName() != null && !NAME_REGEX.matcher(animation.getName()).matches()) {
            errors.rejectValue("email", "Regex.userform.name");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
        if (animation.getGenre() != null && !GENRE_REGEX.matcher(animation.getGenre()).matches()) {
            errors.rejectValue("email", "Regex.userform.gerne");
        }

    }
}
