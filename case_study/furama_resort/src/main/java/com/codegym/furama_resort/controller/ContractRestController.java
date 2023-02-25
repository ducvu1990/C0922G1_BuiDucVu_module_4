package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.dto.ContractDetailDTO;
import com.codegym.furama_resort.model.ContractDetail;
import com.codegym.furama_resort.service.IContractDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/api/contract")
public class ContractRestController {
    @Autowired
    private IContractDetailService contractDetailService;
    @GetMapping("/contractDetailList")
    public ResponseEntity<List<ContractDetailDTO>> showList(@RequestParam(required = false,defaultValue = "0") int id){
        List<ContractDetail> contractDetails = contractDetailService.findContractDetailByContractId(id);
        List<ContractDetailDTO> contractDetailDTOS= new ArrayList<>();
        for (ContractDetail item :contractDetails) {
            ContractDetailDTO contractDetailDTO = new ContractDetailDTO();
            contractDetailDTO.setCost(item.getAttachFacility().getCost());
            contractDetailDTO.setName(item.getAttachFacility().getName());
            contractDetailDTO.setQuantity(item.getQuantity());
            contractDetailDTOS.add(contractDetailDTO);
        }
        if (contractDetails.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(contractDetailDTOS,HttpStatus.OK);
    }
    @PostMapping("/saveContracDetail")
    public ResponseEntity<String> saveContracDetail(List<ContractDetail> contractDetails){
        for (ContractDetail item :contractDetails) {
            contractDetailService.saveContractDetail(item);
        }
        return new ResponseEntity<>("ok",HttpStatus.OK);
    }
}
