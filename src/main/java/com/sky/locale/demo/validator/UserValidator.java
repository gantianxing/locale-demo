package com.sky.locale.demo.validator;

import com.sky.locale.demo.moudle.User;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

/**
 * Created by gantianxing on 2017/6/13.
 */
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        User user = (User) o;
        ValidationUtils.rejectIfEmpty(errors, "name", "username.required");
        BigDecimal money = user.getMoney();
        if (money != null && money.compareTo(BigDecimal.ZERO) < 0) {
            errors.rejectValue("money", "money.negative");
        }
    }
}
