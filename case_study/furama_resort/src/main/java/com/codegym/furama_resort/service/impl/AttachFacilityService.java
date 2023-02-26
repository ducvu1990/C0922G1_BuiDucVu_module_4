package com.codegym.furama_resort.service.impl;


import com.codegym.furama_resort.model.AttachFacility;
import com.codegym.furama_resort.repository.IAttachFacilityRepository;
import com.codegym.furama_resort.service.IAttachFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachFacilityService implements IAttachFacilityService {
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;
    @Override
    public List<AttachFacility> findAllAttachFacility() {
        return attachFacilityRepository.findAll();
    }

    @Override
    public AttachFacility findAttachFacility(int id) {
        return attachFacilityRepository.findById(id).get();
    }


}
