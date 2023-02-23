package com.codegym.furama_resort.service;

import com.codegym.furama_resort.dto.IAttachFacilityDTO;
import com.codegym.furama_resort.model.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAllAttachFacility();
    List<IAttachFacilityDTO> findAllAttachFacilityByCOntractId(int id);
}
