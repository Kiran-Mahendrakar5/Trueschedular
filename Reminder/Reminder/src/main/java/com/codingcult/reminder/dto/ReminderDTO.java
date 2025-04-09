package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "reminders")
public class ReminderDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String phoneNumber; // Mandatory identifier
    private String friendName;
    private String reminderType;
    private LocalDateTime eventDate;
    private String message;
    private boolean isActive = true;

    public ReminderDTO() {}

    public ReminderDTO(String phoneNumber, String friendName, String reminderType,
                       LocalDateTime eventDate, String message) {
        this.phoneNumber = phoneNumber;
        this.friendName = friendName;
        this.reminderType = reminderType;
        this.eventDate = eventDate;
        this.message = message;
        this.isActive = true;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getFriendName() { return friendName; }
    public void setFriendName(String friendName) { this.friendName = friendName; }

    public String getReminderType() { return reminderType; }
    public void setReminderType(String reminderType) { this.reminderType = reminderType; }

    public LocalDateTime getEventDate() { return eventDate; }
    public void setEventDate(LocalDateTime eventDate) { this.eventDate = eventDate; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
