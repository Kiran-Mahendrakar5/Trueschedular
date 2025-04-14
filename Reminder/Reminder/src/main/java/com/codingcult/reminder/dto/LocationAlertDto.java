package com.codingcult.reminder.dto;

import com.codingcult.reminder.enums.NotificationStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "location_alerts")
public class LocationAlertDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userPhoneNumber;
    private String message;
    private double latitude;
    private double longitude;
    private double radius; // Alert trigger radius in meters

    private LocalDateTime triggerTime;
    
    @Enumerated(EnumType.STRING)
    private NotificationStatus status;  // e.g., PENDING, SENT, SNOOZED

    private String taskId;  // Task or schedule linked to this alert

    // Default constructor
    public LocationAlertDto() {}

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

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    @Override
    public String toString() {
        return "LocationAlertDto{" +
                "id=" + id +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                ", message='" + message + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", radius=" + radius +
                ", triggerTime=" + triggerTime +
                ", status=" + status +
                ", taskId='" + taskId + '\'' +
                '}';
    }
}
