package com.codegym.furama_resort.controller;

import com.codegym.furama_resort.dto.AttachFacilityDTO;
import com.codegym.furama_resort.dto.ContractDetailDTO;
import com.codegym.furama_resort.dto.ContractDetailResultDTO;
import com.codegym.furama_resort.model.Contract;
import com.codegym.furama_resort.model.ContractDetail;
import com.codegym.furama_resort.service.IAttachFacilityService;
import com.codegym.furama_resort.service.IContractDetailService;
import com.codegym.furama_resort.service.IContractService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/contract")
public class ContractRestController {
    @Autowired
    private IContractDetailService contractDetailService;
    @Autowired
    private IContractService contractService;
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

    @PostMapping("/saveContractDetail")
    public ResponseEntity<String> saveContractDetail(@RequestBody Map<String, Object> objectMap){
        ObjectMapper objectMapper = new ObjectMapper();
        Contract contract = objectMapper.convertValue(objectMap.get("contract"), Contract.class);
        List<Map<String, Object>> attachFacilityMaps = (List<Map<String, Object>>) objectMap.get("attachFacility");
        List<AttachFacilityDTO> attachFacilities = new ArrayList<>();
        for (Map<String, Object> attachFacilityMap : attachFacilityMaps) {
            AttachFacilityDTO attachFacility = objectMapper.convertValue(attachFacilityMap, AttachFacilityDTO.class);
            attachFacilities.add(attachFacility);
        }
        contractService.save(contract,attachFacilities);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//    let contractsDetailsData = {
//            attachFacility: listContractDetail,
//    contract: contract
//}
}
