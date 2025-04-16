package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reminders")
public class ReminderDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String category; // Bill, User, etc.
    private LocalDateTime reminderTime;
    private boolean isRecurring;
    private String repeatCycle; // DAILY, WEEKLY, etc.
    private boolean isActive = true;

    // New fields to handle message, phone number, description, and task link
    private String message;
    private String phoneNumber;
    private String description;
    private String taskLink;  // New field for task link

    public ReminderDto() {}

    public ReminderDto(int id, String title, String category, LocalDateTime reminderTime, boolean isRecurring,
                       String repeatCycle, boolean isActive, String message, String phoneNumber, 
                       String description, String taskLink) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.reminderTime = reminderTime;
        this.isRecurring = isRecurring;
        this.repeatCycle = repeatCycle;
        this.isActive = isActive;
        this.message = message;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.taskLink = taskLink;  // Initialize the task link
    }

    @Override
    public String toString() {
        return "ReminderDto [id=" + id + ", title=" + title + ", category=" + category + ", reminderTime="
                + reminderTime + ", isRecurring=" + isRecurring + ", repeatCycle=" + repeatCycle + ", isActive="
                + isActive + ", message=" + message + ", phoneNumber=" + phoneNumber + ", description=" + description
                + ", taskLink=" + taskLink + "]";
    }

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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public LocalDateTime getReminderTime() {
        return reminderTime;
    }

    public void setReminderTime(LocalDateTime reminderTime) {
        this.reminderTime = reminderTime;
    }

    public boolean isRecurring() {
        return isRecurring;
    }

    public void setRecurring(boolean isRecurring) {
        this.isRecurring = isRecurring;
    }

    public String getRepeatCycle() {
        return repeatCycle;
    }

    public void setRepeatCycle(String repeatCycle) {
        this.repeatCycle = repeatCycle;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskLink() {
        return taskLink;
    }

    public void setTaskLink(String taskLink) {
        this.taskLink = taskLink;
    }
}
