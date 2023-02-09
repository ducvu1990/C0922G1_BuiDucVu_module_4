package com.codegym.custom_validation.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import java.lang.annotation.Annotation;

public class PhoneNumber implements Validator {
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    public PhoneNumber() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PhoneNumber phoneNumber = (PhoneNumber) target;
        String number = phoneNumber.getNumber();
        if (number.length()<10 || number.length()>11){
            errors.rejectValue("number","phoneNumber1","độ dài không hợp lệ");
        }else if (!number.startsWith("0")){
            errors.rejectValue("number", "phoneNumber2","bắt đầu bằng số 0");
        } else if (!number.matches("(^$|[0-9]*$)")){
            errors.rejectValue("number","phoneNumber3","không đúng định dạng");
        }
    }
}
