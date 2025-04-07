package com.codingcult.notifyme.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "location_based_alerts")
public class LocationBasedAlertsDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "user_latitude", nullable = false)
    private Double userLatitude;

    @Column(name = "user_longitude", nullable = false)
    private Double userLongitude;

    @Column(name = "event_name", nullable = false)
    private String eventName;

    @Column(name = "event_location", nullable = false)
    private String eventLocation;

    @Column(name = "event_time", nullable = false)
    private LocalDateTime eventTime;

    @Column(name = "alert_message", nullable = false)
    private String alertMessage;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "is_active")
    private boolean isActive = true;

    public LocationBasedAlertsDTO() {}

    public LocationBasedAlertsDTO(Long eventId, Double userLatitude, Double userLongitude, String eventName,
                                   String eventLocation, LocalDateTime eventTime, String alertMessage, String phoneNumber, boolean isActive) {
        this.eventId = eventId;
        this.userLatitude = userLatitude;
        this.userLongitude = userLongitude;
        this.eventName = eventName;
        this.eventLocation = eventLocation;
        this.eventTime = eventTime;
        this.alertMessage = alertMessage;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEventId() { return eventId; }
    public void setEventId(Long eventId) { this.eventId = eventId; }

    public Double getUserLatitude() { return userLatitude; }
    public void setUserLatitude(Double userLatitude) { this.userLatitude = userLatitude; }

    public Double getUserLongitude() { return userLongitude; }
    public void setUserLongitude(Double userLongitude) { this.userLongitude = userLongitude; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public String getEventLocation() { return eventLocation; }
    public void setEventLocation(String eventLocation) { this.eventLocation = eventLocation; }

    public LocalDateTime getEventTime() { return eventTime; }
    public void setEventTime(LocalDateTime eventTime) { this.eventTime = eventTime; }

    public String getAlertMessage() { return alertMessage; }
    public void setAlertMessage(String alertMessage) { this.alertMessage = alertMessage; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}