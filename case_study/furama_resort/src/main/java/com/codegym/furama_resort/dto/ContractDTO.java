package com.codegym.furama_resort.dto;

import com.codegym.furama_resort.model.Customer;
import com.codegym.furama_resort.model.Employee;
import com.codegym.furama_resort.model.Facility;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

public class ContractDTO {
    private int id;
    private Date startDate;
    private Date endDate;
    private double deposit;

    private Employee employee;

    private Customer customer;

    private Facility facility;

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
