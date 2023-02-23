package com.codegym.furama_resort.repository;

import com.codegym.furama_resort.model.Customer;
import com.codegym.furama_resort.model.CustomerType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    @Query(value = "select * from furama_resort.customer where name like concat('%',:name,'%') and email" +
            " like concat('%',:email,'%')" +
            " and customer_type_id like concat('%',:id,'%')", nativeQuery = true)
    Page<Customer> findByNameContaining(@Param("name") String name,@Param("email") String email,@Param("id") String id,
                                        Pageable pageable);
    Customer findByEmail(String email);
    Customer findByPhoneNumber(String phoneNumber);
    Customer findByIdCard(String idCard);
}
