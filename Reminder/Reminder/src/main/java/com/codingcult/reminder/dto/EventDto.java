package com.codingcult.reminder.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class EventDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 15)
    private String userPhoneNumber;

    @NotNull
    @Size(max = 100)
    private String title;

    private String description;

    @NotNull
    private LocalDateTime startTime;

    @NotNull
    private LocalDateTime endTime;

    private String location;

    private boolean sendToCalendar;

    private boolean sendToReminder;

    private boolean sendToFriendService;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isSendToCalendar() {
        return sendToCalendar;
    }

    public void setSendToCalendar(boolean sendToCalendar) {
        this.sendToCalendar = sendToCalendar;
    }

    public boolean isSendToReminder() {
        return sendToReminder;
    }

    public void setSendToReminder(boolean sendToReminder) {
        this.sendToReminder = sendToReminder;
    }

    public boolean isSendToFriendService() {
        return sendToFriendService;
    }

    public void setSendToFriendService(boolean sendToFriendService) {
        this.sendToFriendService = sendToFriendService;
    }

	public EventDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventDto(Long id, @NotNull @Size(max = 15) String userPhoneNumber, @NotNull @Size(max = 100) String title,
			String description, @NotNull LocalDateTime startTime, @NotNull LocalDateTime endTime, String location,
			boolean sendToCalendar, boolean sendToReminder, boolean sendToFriendService) {
		super();
		this.id = id;
		this.userPhoneNumber = userPhoneNumber;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.location = location;
		this.sendToCalendar = sendToCalendar;
		this.sendToReminder = sendToReminder;
		this.sendToFriendService = sendToFriendService;
	}

	@Override
	public String toString() {
		return "EventDto [id=" + id + ", userPhoneNumber=" + userPhoneNumber + ", title=" + title + ", description="
				+ description + ", startTime=" + startTime + ", endTime=" + endTime + ", location=" + location
				+ ", sendToCalendar=" + sendToCalendar + ", sendToReminder=" + sendToReminder + ", sendToFriendService="
				+ sendToFriendService + "]";
	}
    
    
}
