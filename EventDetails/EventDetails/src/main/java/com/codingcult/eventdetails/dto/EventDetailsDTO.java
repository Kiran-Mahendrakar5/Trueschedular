package com.codingcult.eventdetails.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "event_details")
public class EventDetailsDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Phone number cannot be blank")
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @NotBlank(message = "Event title cannot be blank")
    @Column(name = "event_title", nullable = false)
    private String eventTitle;

    @NotNull(message = "Event start time cannot be null")
    @Column(name = "event_start_time", nullable = false)
    private LocalDateTime eventStartTime;

    @Column(name = "event_end_time")
    private LocalDateTime eventEndTime;

    @Column(name = "notification_enabled")
    private Boolean notificationEnabled = true;

    @Column(name = "sync_with_external_calendar")
    private Boolean syncWithExternalCalendar = false;

    @Column(name = "is_active")
    private boolean isActive = true;

    public EventDetailsDTO() {
        super();
    }

    public EventDetailsDTO(Long id, String phoneNumber, String eventTitle, LocalDateTime eventStartTime,
                           LocalDateTime eventEndTime, Boolean notificationEnabled,
                           Boolean syncWithExternalCalendar, boolean isActive) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.eventTitle = eventTitle;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.notificationEnabled = notificationEnabled;
        this.syncWithExternalCalendar = syncWithExternalCalendar;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "EventDetailsDTO [id=" + id + ", phoneNumber=" + phoneNumber + ", eventTitle=" + eventTitle
                + ", eventStartTime=" + eventStartTime + ", eventEndTime=" + eventEndTime + ", notificationEnabled="
                + notificationEnabled + ", syncWithExternalCalendar=" + syncWithExternalCalendar + ", isActive=" + isActive + "]";
    }

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

    public LocalDateTime getEventStartTime() {
        return eventStartTime;
    }

    public void setEventStartTime(LocalDateTime eventStartTime) {
        this.eventStartTime = eventStartTime;
    }

    public LocalDateTime getEventEndTime() {
        return eventEndTime;
    }

    public void setEventEndTime(LocalDateTime eventEndTime) {
        this.eventEndTime = eventEndTime;
    }

    public Boolean getNotificationEnabled() {
        return notificationEnabled;
    }

    public void setNotificationEnabled(Boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }

    public Boolean getSyncWithExternalCalendar() {
        return syncWithExternalCalendar;
    }

    public void setSyncWithExternalCalendar(Boolean syncWithExternalCalendar) {
        this.syncWithExternalCalendar = syncWithExternalCalendar;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }
}
