package com.kitabxana_sb.validator;

import com.kitabxana_sb.tables.User_info;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class TextBoxValidator
        implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return User_info.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User_info user = (User_info) o;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "full_name", "error1");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error2");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error3");
    }
}
