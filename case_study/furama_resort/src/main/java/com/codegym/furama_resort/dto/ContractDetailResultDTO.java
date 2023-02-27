package com.codegym.furama_resort.dto;

import com.codegym.furama_resort.model.AttachFacility;
import com.codegym.furama_resort.model.Contract;

public class ContractDetailResultDTO {
    private AttachFacility attachFacility;
    private int quantity;
    private Contract contract;

    public ContractDetailResultDTO() {
    }

    public ContractDetailResultDTO(AttachFacility attachFacility, int quantity, Contract contract) {
        this.attachFacility = attachFacility;
        this.quantity = quantity;
        this.contract = contract;
    }

    public AttachFacility getAttachFacility() {
        return attachFacility;
    }

    public void setAttachFacility(AttachFacility attachFacility) {
        this.attachFacility = attachFacility;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
