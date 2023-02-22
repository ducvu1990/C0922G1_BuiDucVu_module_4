package com.codegym.furama_resort.repository;

import com.codegym.furama_resort.model.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {
}
