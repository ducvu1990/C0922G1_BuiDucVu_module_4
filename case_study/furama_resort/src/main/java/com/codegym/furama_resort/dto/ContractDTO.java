package com.codegym.furama_resort.dto;

import com.codegym.furama_resort.model.Customer;
import com.codegym.furama_resort.model.Employee;
import com.codegym.furama_resort.model.Facility;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class ContractDTO implements Validator {
    private int id;
    private Date startDate;
    private Date endDate;
    private double deposit;

    private Employee employee;

    private Customer customer;

    private Facility facility;

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ContractDTO contractDTO = (ContractDTO) target;
        Date startDate = contractDTO.getStartDate();
        Date endDate = contractDTO.getEndDate();
        LocalDate localDate = LocalDate.now();
        int now = Period.between(localDate, startDate.toLocalDate()).getDays();
        if (now<0){
            errors.rejectValue("startDate","startDate", "ngày làm hợp đồng phải là ngyaf hiện tại hoặc tương lai");
        }
        int numberOfDaysOfUse = Period.between(startDate.toLocalDate(),endDate.toLocalDate()).getDays();
        if (numberOfDaysOfUse<0){
            errors.rejectValue("endDate","endDate", "ngày kết thúc phải sau ngày làm hợp đồng");
        }
    }

    public ContractDTO() {
    }

    public ContractDTO(int id, Date startDate, Date endDate, double deposit, Employee employee, Customer customer, Facility facility) {
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.deposit = deposit;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double deposit) {
        this.deposit = deposit;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }


}
