package com.codegym.furama_resort.service;

import com.codegym.furama_resort.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFacilityService {
    boolean save(Facility facility);
    Page<Facility> search(String name,String FacilityTypeName, Pageable pageable);
    void delete(int id);
    void update(Facility facility);
}
