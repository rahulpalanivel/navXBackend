package com.navx.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking")
public class Booking {
    @Id
    private String id;
    private String userId;
    private String driverId;
    private String paymentId;
    private String vehicleId;
    private String source;
    private String destination;
    private LatLng sourceLatLng;
    private LatLng destinationLatLng;
    private String status; 
    private String paymentStatus;



    public Booking(String id, String userId, String driverId, String paymentId, String vehicleId, String source, String destination, LatLng sourceLatLng, LatLng destinationLatLng, String status, String paymentStatus) {
        this.id = id;
        this.userId = userId;
        this.driverId = driverId;
        this.paymentId = paymentId;
        this.vehicleId = vehicleId;
        this.source = source;
        this.destination = destination;
        this.sourceLatLng = sourceLatLng;
        this.destinationLatLng = destinationLatLng;
        this.status = status;
        this.paymentStatus = paymentStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LatLng getSourceLatLng() {
        return sourceLatLng;
    }

    public void setSourceLatLng(LatLng sourceLatLng) {
        this.sourceLatLng = sourceLatLng;
    }

    public LatLng getDestinationLatLng() {
        return destinationLatLng;
    }

    public void setDestinationLatLng(LatLng destinationLatLng) {
        this.destinationLatLng = destinationLatLng;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
