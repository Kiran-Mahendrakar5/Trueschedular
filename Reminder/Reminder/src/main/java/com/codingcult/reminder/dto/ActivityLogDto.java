package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
public class ActivityLogDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userPhoneNumber;
    private String actionType;        // e.g., "PURCHASE", "EVENT_CREATED", "REMINDER_TRIGGERED"
    private String description;       // Detailed description of action
    private LocalDateTime timestamp;
    private String referenceId;       // Optional: reference to item/event/reminder ID

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

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

	public ActivityLogDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActivityLogDto(int id, String userPhoneNumber, String actionType, String description,
			LocalDateTime timestamp, String referenceId) {
		super();
		this.id = id;
		this.userPhoneNumber = userPhoneNumber;
		this.actionType = actionType;
		this.description = description;
		this.timestamp = timestamp;
		this.referenceId = referenceId;
	}

	@Override
	public String toString() {
		return "ActivityLogDto [id=" + id + ", userPhoneNumber=" + userPhoneNumber + ", actionType=" + actionType
				+ ", description=" + description + ", timestamp=" + timestamp + ", referenceId=" + referenceId + "]";
	}
    
    
}
