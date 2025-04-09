package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ReminderNotificationsDTO;
import java.util.List;

public interface ReminderNotificationsService {

    ReminderNotificationsDTO createNotification(ReminderNotificationsDTO dto);

    List<ReminderNotificationsDTO> getAllActiveNotifications();

    void deactivateNotification(Long id);

    void sendScheduledNotifications();

    void sendNotificationToPhone(String phoneNumber, String message);
}
