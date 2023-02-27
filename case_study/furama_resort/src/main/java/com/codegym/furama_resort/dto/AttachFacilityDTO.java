package com.codegym.furama_resort.dto;

import com.codegym.furama_resort.model.Facility;

public class AttachFacilityDTO {
    private Facility attachFacility;
    private Integer quantity;

    public Facility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(Facility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
