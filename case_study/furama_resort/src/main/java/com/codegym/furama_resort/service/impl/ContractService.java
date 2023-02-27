package com.codegym.furama_resort.service.impl;

import com.codegym.furama_resort.dto.AttachFacilityDTO;
import com.codegym.furama_resort.dto.IContractDTO;
import com.codegym.furama_resort.model.AttachFacility;
import com.codegym.furama_resort.model.Contract;
import com.codegym.furama_resort.model.ContractDetail;
import com.codegym.furama_resort.repository.IAttachFacilityRepository;
import com.codegym.furama_resort.repository.IContractDetailRepository;
import com.codegym.furama_resort.repository.IContractRepository;
import com.codegym.furama_resort.service.IContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements IContractService {
    @Autowired
    private IContractRepository contractRepository;
    @Autowired
    private IContractDetailRepository contractDetailRepository;
    @Autowired
    private IAttachFacilityRepository attachFacilityRepository;

    @Override
    public Page<IContractDTO> findAll(Pageable pageable) {
        return contractRepository.findAllContract(pageable);
    }

    @Override
    public void save(Contract contract, List<AttachFacilityDTO> attachFacilityDTOS) {
        contractRepository.save(contract);
        for (AttachFacilityDTO attachFacilityDTO : attachFacilityDTOS) {
            AttachFacility attachFacility = attachFacilityRepository.findById(attachFacilityDTO.getAttachFacility().getId()).orElse(null);

            ContractDetail contractDetailNew = new ContractDetail();
            contractDetailNew.setContract(contract);
            contractDetailNew.setQuantity(attachFacilityDTO.getQuantity());
            contractDetailNew.setAttachFacility(attachFacility);
            contractDetailRepository.save(contractDetailNew);
        }
    }

    @Override
    public Contract findNewContractByNewContract() {
        return null;
    }


}
