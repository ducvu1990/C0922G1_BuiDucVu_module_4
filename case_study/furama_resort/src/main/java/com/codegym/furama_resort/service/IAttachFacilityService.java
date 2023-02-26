package com.codegym.furama_resort.service;


import com.codegym.furama_resort.model.AttachFacility;

import java.util.List;

public interface IAttachFacilityService {
    List<AttachFacility> findAllAttachFacility();
    AttachFacility findAttachFacility(int id);
}
