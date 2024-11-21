package com.navx.backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document (collection = "harassment")
public class Harassment {
    @Id
    private String id;
    private LatLng location;
    private double confidence;
    private String timestamp;
    private String bookingId;

    public Harassment(String id, LatLng location, double confidence, String timestamp, String bookingId) {
        this.id = id;
        this.location = location;
        this.confidence = confidence;
        this.timestamp = timestamp;
        this.bookingId = bookingId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LatLng getLocation() {
        return location;
    }

    public void setLocation(LatLng location) {
        this.location = location;
    }

    public double getConfidence() {
        return confidence;
    }

    public void setConfidence(double confidence) {
        this.confidence = confidence;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
