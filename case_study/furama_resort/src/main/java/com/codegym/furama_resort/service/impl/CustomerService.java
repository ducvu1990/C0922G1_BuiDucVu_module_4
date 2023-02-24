package com.codegym.furama_resort.service.impl;

import com.codegym.furama_resort.model.Customer;
import com.codegym.furama_resort.repository.ICustomerRepository;
import com.codegym.furama_resort.repository.ICustomerTypeRepository;
import com.codegym.furama_resort.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public boolean save(Customer customer) {
       if (customerRepository.findByEmail(customer.getEmail())!=null||customerRepository.findByIdCard(customer.getIdCard())!=null
       ||customerRepository.findByPhoneNumber(customer.getPhoneNumber())!=null){
           return false;
       }
        customerRepository.save(customer);
        return true;
    }

    @Override
    public Page<Customer> search(String name,String email, String customerTypeName, Pageable pageable) {
        return customerRepository.findByNameContaining(name,email, customerTypeName, pageable);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

}
