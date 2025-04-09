package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "alarm_schedule")
public class AlarmDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String eventName;

    private LocalDateTime eventDate;

    private String status; // STOP, PAUSE, REMIND LATER, ACTIVE

    private String phoneNumber;

    private boolean isActive = true;

    public AlarmDTO() {}

    public AlarmDTO(String eventName, LocalDateTime eventDate, String status, String phoneNumber, boolean isActive) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.status = status;
        this.phoneNumber = phoneNumber;
        this.isActive = isActive;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getEventName() { return eventName; }
    public void setEventName(String eventName) { this.eventName = eventName; }

    public LocalDateTime getEventDate() { return eventDate; }
    public void setEventDate(LocalDateTime eventDate) { this.eventDate = eventDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
