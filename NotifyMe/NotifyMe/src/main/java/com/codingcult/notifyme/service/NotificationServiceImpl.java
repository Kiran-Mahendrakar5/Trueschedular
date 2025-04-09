
package com.codingcult.notifyme.service;

import com.codingcult.notifyme.dto.NotificationDto;
import com.codingcult.notifyme.repo.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public NotificationDto scheduleNotification(NotificationDto notificationDto) {
        return notificationRepository.save(notificationDto);
    }

    @Override
    @Scheduled(fixedRate = 60000)
    public void sendNotifications() {
        List<NotificationDto> dueNotifications = notificationRepository.findByEventTimeBefore(LocalDateTime.now());

        for (NotificationDto notification : dueNotifications) {
            if ("SMS".equalsIgnoreCase(notification.getNotificationType())) {
                sendSmsNotification(notification.getPhoneNumber(), notification.getMessage());
            }
            // Add more notification types here if needed (e.g., PUSH)
        }

        notificationRepository.deleteAll(dueNotifications);
    }

    private void sendSmsNotification(String phoneNumber, String message) {
        // Placeholder for SMS sending logic (e.g., Twilio API or SMS gateway)
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}