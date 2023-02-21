package com.codegym.furama_resort.service;

import com.codegym.furama_resort.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
     boolean save(Customer customer);
     Page<Customer> search(String name,String email, String id, Pageable pageable);
    void delete(int id);
    void update(Customer customer);
}
