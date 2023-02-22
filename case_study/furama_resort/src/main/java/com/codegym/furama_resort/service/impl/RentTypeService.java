package com.codegym.furama_resort.service.impl;

import com.codegym.furama_resort.model.RentType;
import com.codegym.furama_resort.repository.IRentTypeRepository;
import com.codegym.furama_resort.service.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    private IRentTypeRepository rentTypeRepository;
    @Override
    public List<RentType> listRentType() {
        return rentTypeRepository.findAll();
    }
}
