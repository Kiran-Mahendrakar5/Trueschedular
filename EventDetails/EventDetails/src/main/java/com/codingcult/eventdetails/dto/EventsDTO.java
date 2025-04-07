package com.codingcult.eventdetails.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class EventsDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Phone number cannot be blank")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotBlank(message = "Event title cannot be blank")
    @Column(name = "event_title", nullable = false)
    private String eventTitle;

    @NotNull(message = "Event time cannot be null")
    @Column(name = "event_time", nullable = false)
    private LocalDateTime eventTime;

    @NotBlank(message = "Location cannot be blank")
    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "notify_before_minutes")
    private Integer notifyBeforeMinutes;

    @Column(name = "is_active")
    private boolean isActive = true;

    public EventsDTO() {
    }

    public EventsDTO(Long id, String phoneNumber, String eventTitle, LocalDateTime eventTime, String location, Integer notifyBeforeMinutes, boolean isActive) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.eventTitle = eventTitle;
        this.eventTime = eventTime;
        this.location = location;
        this.notifyBeforeMinutes = notifyBeforeMinutes;
        this.isActive = isActive;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getNotifyBeforeMinutes() {
        return notifyBeforeMinutes;
    }

    public void setNotifyBeforeMinutes(Integer notifyBeforeMinutes) {
        this.notifyBeforeMinutes = notifyBeforeMinutes;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
