package com.codegym.furama_resort.repository;

import com.codegym.furama_resort.model.CustomerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICustomerTypeRepository extends JpaRepository<CustomerType, Integer> {
    @Query(value = "SELECT * FROM furama_resort.customer_type",nativeQuery = true)
    List<CustomerType> findAllCustomerType();
    CustomerType findByNameContaining(String name);
}
