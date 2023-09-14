package com.template.myapi.common.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 휴대폰 형식 검증기
 */
public class PhoneValidator implements ConstraintValidator<Phone, String> {

    private static Pattern pattern = Pattern.compile("^010-\\d{3,4}-\\d{4}$");

    @Override
    public boolean isValid(String inputValue, ConstraintValidatorContext context) {
        return inputValue == null || pattern.matcher(inputValue).matches();
    }
}
