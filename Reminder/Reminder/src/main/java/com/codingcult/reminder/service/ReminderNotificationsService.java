package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ReminderNotificationsDTO;

import java.util.List;

public interface ReminderNotificationsService {

    ReminderNotificationsDTO createNotification(ReminderNotificationsDTO reminderNotificationsDTO);

    List<ReminderNotificationsDTO> getNotificationsByUser(String userEmail);

    List<ReminderNotificationsDTO> getNotificationsByType(String notificationType);

    void sendScheduledNotifications();

    void deleteNotification(Long id);
}
