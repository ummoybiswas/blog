package com.sqh.blog.validator;

import com.sqh.blog.controller.form.PostForm;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class PostValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return PostForm.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "NotEmpty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "text", "NotEmpty");

    }
}
