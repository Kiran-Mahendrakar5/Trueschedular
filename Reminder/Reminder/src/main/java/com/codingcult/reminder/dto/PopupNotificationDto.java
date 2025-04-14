package com.codingcult.reminder.dto;

import javax.persistence.*;
import com.codingcult.reminder.enums.NotificationStatus;
import java.time.LocalDateTime;

@Entity
@Table(name = "popup_notifications")
public class PopupNotificationDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String sourceService; // ReminderService, GeoAlertService, etc.

    private String message;

    private LocalDateTime triggerTime;

    @Enumerated(EnumType.STRING)
    private NotificationStatus status; // PENDING, SNOOZED, DISMISSED, SEEN

    private String userPhoneNumber;

    // Default constructor
    public PopupNotificationDto() {}

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSourceService() {
        return sourceService;
    }

    public void setSourceService(String sourceService) {
        this.sourceService = sourceService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    @Override
    public String toString() {
        return "PopupNotificationDto{" +
                "id=" + id +
                ", sourceService='" + sourceService + '\'' +
                ", message='" + message + '\'' +
                ", triggerTime=" + triggerTime +
                ", status=" + status +
                ", userPhoneNumber='" + userPhoneNumber + '\'' +
                '}';
    }
}
