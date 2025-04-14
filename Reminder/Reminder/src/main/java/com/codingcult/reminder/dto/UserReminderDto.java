package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_reminders")
public class UserReminderDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private LocalDateTime reminderTime;
    private String repeatMode; // Daily, Weekly, etc. (optional)
    private String mediaUrl;   // Optional attachment
    private boolean isActive = true;

    public UserReminderDto() {}

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    public String getRepeatMode() {
        return repeatMode;
    }

    public void setRepeatMode(String repeatMode) {
        this.repeatMode = repeatMode;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "UserReminderDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", reminderTime=" + reminderTime +
                ", repeatMode='" + repeatMode + '\'' +
                ", mediaUrl='" + mediaUrl + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
