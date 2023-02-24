package com.codegym.furama_resort.service.impl;

import com.codegym.furama_resort.model.Facility;
import com.codegym.furama_resort.repository.IFacilityRepository;
import com.codegym.furama_resort.service.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public List<Facility> findAllFacility() {
        return facilityRepository.findAll();
    }

    @Override
    public boolean save(Facility facility) {
       if (facilityRepository.findByName(facility.getName())!=null){
           return false;
       }
        facilityRepository.save(facility);
        return true;
    }

    @Override
    public Page<Facility> search(String name, String FacilityTypeName, Pageable pageable) {
        return facilityRepository.findByNameContaining(name,FacilityTypeName,pageable);
    }

    @Override
    public void delete(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public void update(Facility facility) {
        facilityRepository.save(facility);
    }
}
