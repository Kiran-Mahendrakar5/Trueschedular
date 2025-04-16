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
    
    private String title;      // Title for the popup
    private String timestamp;

    // Default constructor
    public PopupNotificationDto() {}

	public PopupNotificationDto(int id, String sourceService, String message, LocalDateTime triggerTime,
			NotificationStatus status, String userPhoneNumber, String title, String timestamp) {
		super();
		this.id = id;
		this.sourceService = sourceService;
		this.message = message;
		this.triggerTime = triggerTime;
		this.status = status;
		this.userPhoneNumber = userPhoneNumber;
		this.title = title;
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "PopupNotificationDto [id=" + id + ", sourceService=" + sourceService + ", message=" + message
				+ ", triggerTime=" + triggerTime + ", status=" + status + ", userPhoneNumber=" + userPhoneNumber
				+ ", title=" + title + ", timestamp=" + timestamp + "]";
	}

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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
    
    

}