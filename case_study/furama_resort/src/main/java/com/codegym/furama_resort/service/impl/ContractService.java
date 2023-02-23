package com.codegym.furama_resort.service.impl;

import com.codegym.furama_resort.dto.IContractDTO;
import com.codegym.furama_resort.repository.IContractRepository;
import com.codegym.furama_resort.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Override
    public Page<IContractDTO> findAll(Pageable pageable) {
        return contractRepository.findAllContract(pageable);
    }
}
