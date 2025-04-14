package com.codingcult.reminder.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Table(name = "wearable_sync")
public class WearableSyncDto {

    @Id
    private String wearableDeviceId; // e.g., smartwatch ID

    @NotNull(message = "User phone number cannot be null")
    private String userPhoneNumber;

    @NotNull(message = "Event name cannot be null")
    private String eventName;

    @NotNull(message = "Event time cannot be null")
    private LocalDateTime eventTime;

    @NotNull(message = "Reminder message cannot be null")
    private String reminderMessage;

    // Getters and Setters

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }

    public String getReminderMessage() {
        return reminderMessage;
    }

    public void setReminderMessage(String reminderMessage) {
        this.reminderMessage = reminderMessage;
    }

    public String getWearableDeviceId() {
        return wearableDeviceId;
    }

    public void setWearableDeviceId(String wearableDeviceId) {
        this.wearableDeviceId = wearableDeviceId;
    }

	public WearableSyncDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WearableSyncDto(String wearableDeviceId,
			@NotNull(message = "User phone number cannot be null") String userPhoneNumber,
			@NotNull(message = "Event name cannot be null") String eventName,
			@NotNull(message = "Event time cannot be null") LocalDateTime eventTime,
			@NotNull(message = "Reminder message cannot be null") String reminderMessage) {
		super();
		this.wearableDeviceId = wearableDeviceId;
		this.userPhoneNumber = userPhoneNumber;
		this.eventName = eventName;
		this.eventTime = eventTime;
		this.reminderMessage = reminderMessage;
	}

	@Override
	public String toString() {
		return "WearableSyncDto [wearableDeviceId=" + wearableDeviceId + ", userPhoneNumber=" + userPhoneNumber
				+ ", eventName=" + eventName + ", eventTime=" + eventTime + ", reminderMessage=" + reminderMessage
				+ "]";
	}
    
    
}
