package com.codegym.furama_resort.service;

import com.codegym.furama_resort.dto.AttachFacilityDTO;
import com.codegym.furama_resort.dto.IContractDTO;
import com.codegym.furama_resort.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<IContractDTO> findAll(Pageable pageable);
    void save(Contract contract, List<AttachFacilityDTO> attachFacilityDTOS);
    Contract findNewContractByNewContract();
}
