package com.codegym.furama_resort.service.impl;

import com.codegym.furama_resort.model.Employee;
import com.codegym.furama_resort.repository.IEmployeeRepository;
import com.codegym.furama_resort.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private IEmployeeRepository employeeRepository;
    @Override
    public List<Employee> finAllEmployee() {
        return employeeRepository.findAll();
    }
}
