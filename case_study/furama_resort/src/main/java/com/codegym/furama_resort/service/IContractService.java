package com.codegym.furama_resort.service;

import com.codegym.furama_resort.dto.IContractDTO;
import com.codegym.furama_resort.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IContractService {
    Page<IContractDTO> findAll(Pageable pageable);
    void save(Contract contract);
    Contract findNewContractByNewContract();
}
