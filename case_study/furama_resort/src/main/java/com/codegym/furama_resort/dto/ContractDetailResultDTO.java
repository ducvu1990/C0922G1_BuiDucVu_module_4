package com.codegym.furama_resort.dto;

public class ContractDetailResultDTO {
    private int attachFacilityId;
    private int quantity;

    public ContractDetailResultDTO() {
    }

    public ContractDetailResultDTO(int attachFacilityId, int quantity) {
        this.attachFacilityId = attachFacilityId;
        this.quantity = quantity;
    }

    public int getAttachFacilityId() {
        return attachFacilityId;
    }

    public void setAttachFacilityId(int attachFacilityId) {
        this.attachFacilityId = attachFacilityId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
