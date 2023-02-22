package com.codegym.furama_resort.service.impl;

import com.codegym.furama_resort.model.FacilityType;
import com.codegym.furama_resort.repository.IFacilityTypeRepository;
import com.codegym.furama_resort.service.IFaciityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityTypeService implements IFaciityTypeService {
    @Autowired
    private IFacilityTypeRepository facilityTypeRepository;
    @Override
    public List<FacilityType> listFacilityType() {
        return facilityTypeRepository.findAll();
    }
}
