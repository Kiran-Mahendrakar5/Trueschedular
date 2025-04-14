package com.codingcult.reminder.dto;

import javax.persistence.*;

import com.codingcult.reminder.enums.NotificationStatus;

import java.time.LocalDateTime;

@Entity
@Table(name = "geo_alerts")
public class GeoAlertDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userPhoneNumber; // User phone number to send the alert to
    private String message; // Alert message
    private double latitude; // Latitude of the location
    private double longitude; // Longitude of the location
    private double radius; // Radius around the location in meters

    private LocalDateTime triggerTime; // When the alert is triggered

    @Enumerated(EnumType.STRING)
    private NotificationStatus status; // Status like PENDING, SENT, etc.

    // Default constructor
    public GeoAlertDto() {}

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public LocalDateTime getTriggerTime() {
        return triggerTime;
    }

    public void setTriggerTime(LocalDateTime triggerTime) {
        this.triggerTime = triggerTime;
    }

    public NotificationStatus getStatus() {
        return status;
    }

    public void setStatus(NotificationStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GeoAlertDto{" +
                "id=" + id +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", message='" + message + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", radius=" + radius +
                ", triggerTime=" + triggerTime +
                ", status=" + status +
                '}';
    }
}
