package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "calendar_events")
public class CalendarEventDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userPhoneNumber;
    private String title;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean sendToReminder;
    private boolean sendToWearable;

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public boolean isSendToReminder() {
        return sendToReminder;
    }

    public void setSendToReminder(boolean sendToReminder) {
        this.sendToReminder = sendToReminder;
    }

    public boolean isSendToWearable() {
        return sendToWearable;
    }

    public void setSendToWearable(boolean sendToWearable) {
        this.sendToWearable = sendToWearable;
    }

	public CalendarEventDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CalendarEventDto(int id, String userPhoneNumber, String title, String description, LocalDateTime startTime,
			LocalDateTime endTime, boolean sendToReminder, boolean sendToWearable) {
		super();
		this.id = id;
		this.userPhoneNumber = userPhoneNumber;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.sendToReminder = sendToReminder;
		this.sendToWearable = sendToWearable;
	}

	@Override
	public String toString() {
		return "CalendarEventDto [id=" + id + ", userPhoneNumber=" + userPhoneNumber + ", title=" + title
				+ ", description=" + description + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", sendToReminder=" + sendToReminder + ", sendToWearable=" + sendToWearable + "]";
	}
    
    
}
