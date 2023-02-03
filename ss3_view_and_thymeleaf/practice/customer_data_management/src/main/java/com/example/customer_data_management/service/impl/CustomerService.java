package com.example.customer_data_management.service.impl;

import com.example.customer_data_management.model.Customer;
import com.example.customer_data_management.service.ICustomerService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerService implements ICustomerService {
    private static final Map<Integer,Customer> customer;
    static {
        customer =new HashMap<>();
        customer.put(1,new Customer(1,"vu","vu@codegym.com","qung tri"));
        customer.put(2,new Customer(2,"hau","hau@codegym.com","ha noi"));
        customer.put(3,new Customer(3,"nam","nam@codegym.com","quang nam"));
        customer.put(4,new Customer(4,"hoang","hoang@codegym.com","hue"));
        customer.put(5,new Customer(5,"tai","tai@codegym.com","da lat"));
        customer.put(6,new Customer(6,"tien","tien@codegym.com","ho chi minh"));
    }
    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(customer.values());
    }

    @Override
    public void save(Customer customers) {
        customer.put(customers.getId(),customers);
    }

    @Override
    public Customer findById(int id) {
        return customer.get(id);
    }

    @Override
    public void update(int id, Customer customers) {
        customer.put(id,customers);
    }

    @Override
    public void remove(int id) {
        customer.remove(id);
    }
}
