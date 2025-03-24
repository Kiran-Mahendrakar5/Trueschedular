package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.NotificationDTO;

import java.util.List;

public interface NotificationService {

	// Save notification
	public NotificationDTO saveNotification(NotificationDTO notificationDTO);

	// Get notification by ID
	public NotificationDTO getNotificationById(Long id);

	// Get all notifications
	public List<NotificationDTO> getAllNotifications();

	// Get notifications by userId
	public List<NotificationDTO> getNotificationsByUserId(Long userId);

	// Update notification status
	public NotificationDTO updateNotification(Long id, NotificationDTO notificationDTO);

	// Delete notification by ID
	public void deleteNotification(Long id);
}
