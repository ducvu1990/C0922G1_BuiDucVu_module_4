package com.codegym.furama_resort.repository;

import com.codegym.furama_resort.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Integer> {
}
