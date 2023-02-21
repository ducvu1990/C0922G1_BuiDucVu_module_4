package com.codegym.furama_resort.service.impl;

import com.codegym.furama_resort.model.Customer;
import com.codegym.furama_resort.repository.ICustomerRepository;
import com.codegym.furama_resort.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public void save(Customer customer) {
        customerRepository.save(customer);
    }
}
