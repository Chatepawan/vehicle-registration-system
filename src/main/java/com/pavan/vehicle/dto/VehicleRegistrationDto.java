package com.pavan.vehicle.dto;

import lombok.Data;

@Data
public class VehicleRegistrationDto {
    // Vehicle Details
    private String vin;
    private String make;
    private String model;
    private int year;
    private String color;

    // Customer Details
    private String ownerName;
    private String ownerAddress;
    private String ownerEmail;
    private String ownerPhone;
}