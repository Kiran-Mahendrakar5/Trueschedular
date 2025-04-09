package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class ReminderNotificationsDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber;
    private String message;
    private LocalDateTime scheduledTime;
    private boolean isActive = true;

    public ReminderNotificationsDTO() {}

    public ReminderNotificationsDTO(Long id, String phoneNumber, String message, LocalDateTime scheduledTime, boolean isActive) {
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.message = message;
        this.scheduledTime = scheduledTime;
        this.isActive = isActive;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getScheduledTime() { return scheduledTime; }
    public void setScheduledTime(LocalDateTime scheduledTime) { this.scheduledTime = scheduledTime; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean isActive) { this.isActive = isActive; }

    @Override
    public String toString() {
        return "ReminderNotificationsDTO [id=" + id + ", phoneNumber=" + phoneNumber + ", message=" + message +
                ", scheduledTime=" + scheduledTime + ", isActive=" + isActive + "]";
    }
}
