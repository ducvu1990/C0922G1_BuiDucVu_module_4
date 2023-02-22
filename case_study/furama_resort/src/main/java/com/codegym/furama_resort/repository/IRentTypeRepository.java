package com.codegym.furama_resort.repository;

import com.codegym.furama_resort.model.RentType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRentTypeRepository extends JpaRepository<RentType,Integer> {
}
