package com.codegym.furama_resort.service.impl;

import com.codegym.furama_resort.model.ContractDetail;
import com.codegym.furama_resort.repository.IContractDetailRepository;
import com.codegym.furama_resort.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractDetailService implements IContractDetailService {
    @Autowired
    private IContractDetailRepository contractDetailRepository;

    @Override
    public boolean saveContractDetail(ContractDetail contractDetail) {
        if(contractDetail.getQuantity()>0){
            contractDetailRepository.save(contractDetail);
            return true;
        }
        return false;
    }

    @Override
    public List<ContractDetail> findContractDetailByContractId(int id) {
        return contractDetailRepository.findAllByContractId(id);
    }
}
