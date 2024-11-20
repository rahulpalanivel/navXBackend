package com.navx.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "shared")
public class Shared {
    @Id
    private String id;
    private String userid;
    private String vehicleid;
    private String paymentid;

    private String source;
    private String destination;
    private String Datetime;

    private double rating;
    private int totalseats;
    private int availableseats;
    private String sourceLatLng;
    private String destinationLatLng;
    private String currentLatLng;

    public Shared(String id, String userid, String vehicleid, String paymentid, String source, String destination, String datetime, double rating, int totalseats, int availableseats, String sourceLatLng, String destinationLatLng, String currentLatLng) {
        this.id = id;
        this.userid = userid;
        this.vehicleid = vehicleid;
        this.paymentid = paymentid;
        this.source = source;
        this.destination = destination;
        this.Datetime = datetime;
        this.rating = rating;
        this.totalseats = totalseats;
        this.availableseats = availableseats;
        this.sourceLatLng = sourceLatLng;
        this.destinationLatLng = destinationLatLng;
        this.currentLatLng = currentLatLng;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getVehicleid() {
        return vehicleid;
    }

    public void setVehicleid(String vehicleid) {
        this.vehicleid = vehicleid;
    }

    public String getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(String paymentid) {
        this.paymentid = paymentid;
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

    public String getDatetime() {
        return Datetime;
    }

    public void setDatetime(String datetime) {
        Datetime = datetime;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getTotalseats() {
        return totalseats;
    }

    public void setTotalseats(int totalseats) {
        this.totalseats = totalseats;
    }

    public int getAvailableseats() {
        return availableseats;
    }

    public void setAvailableseats(int availableseats) {
        this.availableseats = availableseats;
    }

    public String getSourceLatLng() {
        return sourceLatLng;
    }

    public void setSourceLatLng(String sourceLatLng) {
        this.sourceLatLng = sourceLatLng;
    }

    public String getDestinationLatLng() {
        return destinationLatLng;
    }

    public void setDestinationLatLng(String destinationLatLng) {
        this.destinationLatLng = destinationLatLng;
    }

    public String getCurrentLatLng() {
        return currentLatLng;
    }

    public void setCurrentLatLng(String currentLatLng) {
        this.currentLatLng = currentLatLng;
    }
}