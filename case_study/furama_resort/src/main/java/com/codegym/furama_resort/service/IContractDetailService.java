package com.codegym.furama_resort.service;

import com.codegym.furama_resort.model.ContractDetail;

import java.util.List;

public interface IContractDetailService {
    boolean saveContractDetail(ContractDetail contractDetail);
    List<ContractDetail> findContractDetailByContractId(int id);

}
