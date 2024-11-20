package com.navx.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vehicle")
public class Vehicle {
    @Id
    private String id;
    private String ownerId;
    private String vehicleNumber;
    private String vehicleName;
    private VehicleTypes vehicleType;
    private int capacity;


    public Vehicle(String id, String ownerId, String vehicleNumber, String vehicleName, VehicleTypes vehicleType, int capacity) {
        this.id = id;
        this.ownerId = ownerId;
        this.vehicleNumber = vehicleNumber;
        this.vehicleName = vehicleName;
        this.vehicleType = vehicleType;
        this.capacity = capacity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public VehicleTypes getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleTypes vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
