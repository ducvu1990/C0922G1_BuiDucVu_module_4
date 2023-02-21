package com.codegym.furama_resort.service;

import com.codegym.furama_resort.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

public interface ICustomerService {
    public void save(Customer customer);
}
