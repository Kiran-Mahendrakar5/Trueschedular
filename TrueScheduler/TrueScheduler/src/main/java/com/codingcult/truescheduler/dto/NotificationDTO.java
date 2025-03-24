package com.codingcult.truescheduler.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notification")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class NotificationDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id; // Notification ID
	private Long userId; // User ID receiving notification
	private Long eventId; // Event ID (nullable for offers)
	private String message; // Notification message
	private LocalDateTime notificationTime; // When to send the notification
	private String status;
	public NotificationDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NotificationDTO(Long id, Long userId, Long eventId, String message, LocalDateTime notificationTime,
			String status) {
		super();
		this.id = id;
		this.userId = userId;
		this.eventId = eventId;
		this.message = message;
		this.notificationTime = notificationTime;
		this.status = status;
	}
	@Override
	public String toString() {
		return "NotificationDTO [id=" + id + ", userId=" + userId + ", eventId=" + eventId + ", message=" + message
				+ ", notificationTime=" + notificationTime + ", status=" + status + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getEventId() {
		return eventId;
	}
	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public LocalDateTime getNotificationTime() {
		return notificationTime;
	}
	public void setNotificationTime(LocalDateTime notificationTime) {
		this.notificationTime = notificationTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
