package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ReminderNotificationsDTO;
import com.codingcult.reminder.repo.ReminderNotificationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReminderNotificationsServiceImpl implements ReminderNotificationsService {

    @Autowired
    private ReminderNotificationsRepository reminderNotificationsRepository;

    @Override
    public ReminderNotificationsDTO createNotification(ReminderNotificationsDTO reminderNotificationsDTO) {
        return reminderNotificationsRepository.save(reminderNotificationsDTO);
    }

    @Override
    public List<ReminderNotificationsDTO> getNotificationsByUser(String userEmail) {
        return reminderNotificationsRepository.findByUserEmail(userEmail);
    }

    @Override
    public List<ReminderNotificationsDTO> getNotificationsByType(String notificationType) {
        return reminderNotificationsRepository.findByNotificationType(notificationType);
    }

    @Override
    @Scheduled(cron = "0 0 9 * * *")  // Runs daily at 9 AM
    public void sendScheduledNotifications() {
        LocalDateTime now = LocalDateTime.now();

        List<ReminderNotificationsDTO> notifications = reminderNotificationsRepository.findByReminderDateBeforeAndStatus(now, "PENDING");

        for (ReminderNotificationsDTO notification : notifications) {
            sendNotification(notification);
            notification.setStatus("SENT");
            reminderNotificationsRepository.save(notification);
        }
    }

    private void sendNotification(ReminderNotificationsDTO notification) {
        System.out.println("🔔 Reminder Notification: " + notification.getNotificationType() +
                " - " + notification.getProductName() + " for " + notification.getUserEmail());
        // Implement actual email/SMS push notification logic here.
    }

    @Override
    public void deleteNotification(Long id) {
        reminderNotificationsRepository.deleteById(id);
    }
}
