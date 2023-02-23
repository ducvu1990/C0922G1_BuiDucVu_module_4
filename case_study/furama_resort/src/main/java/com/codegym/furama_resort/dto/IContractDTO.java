package com.codegym.furama_resort.dto;

import java.sql.Date;

public interface IContractDTO {
    int getContractId();
    String getFacilityName();
    String getCustomerName();
    Date getStartDate();
    Date getEndDate();
    double getDeposit();
    double getTotalCost();
}
