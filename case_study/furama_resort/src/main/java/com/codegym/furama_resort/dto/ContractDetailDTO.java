package com.codegym.furama_resort.dto;

public class ContractDetailDTO {
    private double cost;
    private String name;
    private int Quantity;

    public ContractDetailDTO() {
    }

    public ContractDetailDTO(double cost, String name, int quantity) {
        this.cost = cost;
        this.name = name;
        Quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }
}
