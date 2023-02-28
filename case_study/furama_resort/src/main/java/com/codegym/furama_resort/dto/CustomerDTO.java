package com.codegym.furama_resort.dto;

import com.codegym.furama_resort.model.Contract;
import com.codegym.furama_resort.model.CustomerType;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.Set;

public class CustomerDTO implements Validator {
    private int id;
    @NotEmpty(message = "không được để trống")
    @NotBlank(message = "không được để khoảng trống")
    @Pattern(regexp = "^[A-Z][a-z]*( [A-Z][a-z]*)*$",message = "Tên khách hàng không được chứa số. Và các kí tự đầu tiên của mỗi từ phải viết hoa")
    private String name;
    private Date dateOfBirth;
    private boolean gender;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "(\\d{9})|(\\d{12})", message = "Số CMND/CCCD phải đúng định dạng, vd:XXXXXXXXX hoặc XXXXXXXXXXXX " +
            "(X là số 0-9, độ dài CMND 9 số, CCCD 12 số).")
    private String idCard;
    @NotBlank(message = "không được để trống")
    @Pattern(regexp = "^((\\+?84)|0)(9[01]\\d{7})$", message = "Số điện thoại chưa đúng định dạng, số điện thoại phải có" +
            " dạng: 090xxxxxxx hoặc 091xxxxxxx hoặc +8490xxxxxxx hoặc +8491xxxxxxx.")
    private String phoneNumber;
    @Pattern(regexp = "^[\\w._%+-]+@[\\w.-]+\\.[A-Za-z]{2,}$", message = "Email phải đúng định dạng, vd: hau123@gmail.com")
    private String email;
    private String address;
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDTO customerDTO = (CustomerDTO) target;
        Date dateOfBirth = customerDTO.getDateOfBirth();
        LocalDate now = LocalDate.now();
        int age = Period.between(dateOfBirth.toLocalDate(),now).getYears();
        if (age <= 18 || age>=90){
            errors.rejectValue("dateOfBirth", "dateOfBirth","ngày sinh không đúng, bạn phải " +
                    "lớn hơn 18 tuổi và nhỏ hơn 90 tuổi");
        }
    }

    private CustomerType customerType;

    private Set<Contract> contracts;

    public CustomerDTO() {
    }

    public CustomerDTO(int id, String name, Date dateOfBirth, boolean gender, String idCard, String phoneNumber,
                       String email, String address, CustomerType customerType, Set<Contract> contracts) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
