package com.codegym.furama_resort.dto;

import com.codegym.furama_resort.model.FacilityType;
import com.codegym.furama_resort.model.RentType;

import javax.validation.constraints.*;

public class FacilityDTO {
    private int id;
    @NotBlank(message = "không để khoảng trống")
    @Pattern(regexp = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*\\s\\d*$", message = "Tên dịch vụ không được chứa kí tự đặc biệt")
    private String name;
    @Min(value = 0,message = "phải là số nguyên dương")
    private int area;
    @Min(value = 0,message = "phải là số dương")
    private double cost;
    @Min(value = 0,message = "phải là số nguyên dương")
    private int maxPeople;
    private String standardRoom;
    private String descriptionOtherConvenience;
    @Min(value = 0,message = "phải là số dương")
    private double poolArea;
    @Min(value = 0,message = "phải là số nguyên dương")
    private int numberOfFloors;
    private String facilityFree;

    private FacilityType facilityType;

    private RentType rentType;

    public FacilityDTO() {
    }

    public FacilityDTO(int id, String name, int area, double cost, int maxPeople, String standardRoom,
                       String descriptionOtherConvenience, double poolArea, int numberOfFloors, String facilityFree,
                       FacilityType facilityType, RentType rentType) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.maxPeople = maxPeople;
        this.standardRoom = standardRoom;
        this.descriptionOtherConvenience = descriptionOtherConvenience;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.facilityFree = facilityFree;
        this.facilityType = facilityType;
        this.rentType = rentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescriptionOtherConvenience() {
        return descriptionOtherConvenience;
    }

    public void setDescriptionOtherConvenience(String descriptionOtherConvenience) {
        this.descriptionOtherConvenience = descriptionOtherConvenience;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(int numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public String getFacilityFree() {
        return facilityFree;
    }

    public void setFacilityFree(String facilityFree) {
        this.facilityFree = facilityFree;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }
}
