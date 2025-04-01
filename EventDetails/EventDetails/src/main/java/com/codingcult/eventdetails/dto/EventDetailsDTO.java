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

    @NotBlank(message = "User email cannot be blank")
    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @NotBlank(message = "Event title cannot be blank")
    @Column(name = "event_title", nullable = false)
    private String eventTitle;

    @NotNull(message = "Event start time cannot be null")
    @Column(name = "event_start_time", nullable = false)
    private LocalDateTime eventStartTime;

    @Column(name = "event_end_time")
    private LocalDateTime eventEndTime;

    @Column(name = "recurrence_pattern") 
    private String recurrencePattern; // Example: DAILY, WEEKLY, MONTHLY, NONE

    @Column(name = "notification_enabled")
    private Boolean notificationEnabled = true; // Default notifications enabled

    @Column(name = "sync_with_external_calendar")
    private Boolean syncWithExternalCalendar = false; // Default: Not syncing

    public EventDetailsDTO() {
        super();
    }

    public EventDetailsDTO(Long id, String userEmail, String eventTitle, LocalDateTime eventStartTime,
                           LocalDateTime eventEndTime, String recurrencePattern, Boolean notificationEnabled,
                           Boolean syncWithExternalCalendar) {
        this.id = id;
        this.userEmail = userEmail;
        this.eventTitle = eventTitle;
        this.eventStartTime = eventStartTime;
        this.eventEndTime = eventEndTime;
        this.recurrencePattern = recurrencePattern;
        this.notificationEnabled = notificationEnabled;
        this.syncWithExternalCalendar = syncWithExternalCalendar;
    }

    @Override
    public String toString() {
        return "EventDetailsDTO [id=" + id + ", userEmail=" + userEmail + ", eventTitle=" + eventTitle +
                ", eventStartTime=" + eventStartTime + ", eventEndTime=" + eventEndTime +
                ", recurrencePattern=" + recurrencePattern + ", notificationEnabled=" + notificationEnabled +
                ", syncWithExternalCalendar=" + syncWithExternalCalendar + "]";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getEventTitle() { return eventTitle; }
    public void setEventTitle(String eventTitle) { this.eventTitle = eventTitle; }

    public LocalDateTime getEventStartTime() { return eventStartTime; }
    public void setEventStartTime(LocalDateTime eventStartTime) { this.eventStartTime = eventStartTime; }

    public LocalDateTime getEventEndTime() { return eventEndTime; }
    public void setEventEndTime(LocalDateTime eventEndTime) { this.eventEndTime = eventEndTime; }

    public String getRecurrencePattern() { return recurrencePattern; }
    public void setRecurrencePattern(String recurrencePattern) { this.recurrencePattern = recurrencePattern; }

    public Boolean getNotificationEnabled() { return notificationEnabled; }
    public void setNotificationEnabled(Boolean notificationEnabled) { this.notificationEnabled = notificationEnabled; }

    public Boolean getSyncWithExternalCalendar() { return syncWithExternalCalendar; }
    public void setSyncWithExternalCalendar(Boolean syncWithExternalCalendar) { this.syncWithExternalCalendar = syncWithExternalCalendar; }
}
