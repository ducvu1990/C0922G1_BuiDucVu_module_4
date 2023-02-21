package com.codegym.furama_resort.service;

import com.codegym.furama_resort.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    public boolean save(Customer customer);
    public Page<Customer> search(String name,String email, String id, Pageable pageable);
}
