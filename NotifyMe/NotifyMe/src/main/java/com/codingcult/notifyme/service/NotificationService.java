package com.codingcult.notifyme.service;

import com.codingcult.notifyme.dto.NotificationDto;
import java.util.List;

public interface NotificationService {
    NotificationDto scheduleNotification(NotificationDto notificationDto); // Schedule a notification
    void sendNotifications();  // Send notifications
}
