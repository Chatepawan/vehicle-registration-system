package com.pavan.vehicle.model;

public class VehicleSearchCriteria {
    private String vin;
    private String make;
    private String model;
    private String color;

    // Constructors
    public VehicleSearchCriteria() {}

    public VehicleSearchCriteria(String vin, String make, String model, String color) {
        this.vin = vin;
        this.make = make;
        this.model = model;
        this.color = color;
    }

    // Getters and Setters
    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}