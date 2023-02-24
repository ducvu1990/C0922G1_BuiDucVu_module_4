package com.codegym.furama_resort.service;

import com.codegym.furama_resort.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
     boolean save(Customer customer);
     Page<Customer> search(String name,String email, String id, Pageable pageable);
    void delete(int id);
    void update(Customer customer);
    List<Customer> findAllCustomer();
}
