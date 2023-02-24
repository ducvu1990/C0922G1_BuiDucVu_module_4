package com.codegym.furama_resort.repository;

import com.codegym.furama_resort.model.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {
    List<ContractDetail> findAllByContractId(int id);
}
