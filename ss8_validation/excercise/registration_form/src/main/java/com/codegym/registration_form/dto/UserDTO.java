package com.codegym.registration_form.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


public class UserDTO implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotEmpty
    @Size(min = 5, max = 45)
    private String firstname;
    @NotEmpty
    @Size(min = 5, max = 45)
    private String lastname;

    private String phonenumber;
    @Min(18)
    private int age;
    @Email
    private String email;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDTO user = (UserDTO) target;
        String number = user.getPhonenumber();
        if (number.length() < 10 || number.length() > 11) {
            errors.rejectValue("phonenumber", "phoneNumber1", "Invalid length");
        } else if (!number.startsWith("0")) {
            errors.rejectValue("phonenumber", "phoneNumber2", "start with 0");
        } else if (!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("phonenumber", "phoneNumber3", "Malformed");
        }
    }

    public UserDTO() {
    }

    public UserDTO(int id, String firstname, String lastname, String phonenumber, int age, String email) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.phonenumber = phonenumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
