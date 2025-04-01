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

    private String userEmail;  // User receiving the notification
    private String friendName; // Friend's name
    private String reminderType; // BIRTHDAY, ANNIVERSARY, CUSTOM
    private LocalDateTime eventDate; // Date & time of the event
    private String message;  // Notification message

    // Default Constructor
    public ReminderDTO() {}

    // Constructor
    public ReminderDTO(String userEmail, String friendName, String reminderType, LocalDateTime eventDate, String message) {
        this.userEmail = userEmail;
        this.friendName = friendName;
        this.reminderType = reminderType;
        this.eventDate = eventDate;
        this.message = message;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getFriendName() { return friendName; }
    public void setFriendName(String friendName) { this.friendName = friendName; }

    public String getReminderType() { return reminderType; }
    public void setReminderType(String reminderType) { this.reminderType = reminderType; }

    public LocalDateTime getEventDate() { return eventDate; }
    public void setEventDate(LocalDateTime eventDate) { this.eventDate = eventDate; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}

