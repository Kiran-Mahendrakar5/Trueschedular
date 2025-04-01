package com.codingcult.notifyme.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
public class NotificationDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;  // User's email for email notifications
    private String phoneNumber; // User's phone for SMS
    private String notificationType; // EMAIL, PUSH, SMS
    private String message;    // Notification message
    private LocalDateTime eventTime; // Event time for reminders

    // Default Constructor
    public NotificationDto() {}

    // Constructor
    public NotificationDto(String userEmail, String phoneNumber, String notificationType, String message, LocalDateTime eventTime) {
        this.userEmail = userEmail;
        this.phoneNumber = phoneNumber;
        this.notificationType = notificationType;
        this.message = message;
        this.eventTime = eventTime;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getNotificationType() { return notificationType; }
    public void setNotificationType(String notificationType) { this.notificationType = notificationType; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getEventTime() { return eventTime; }
    public void setEventTime(LocalDateTime eventTime) { this.eventTime = eventTime; }
}
