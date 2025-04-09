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
    private ReminderNotificationsRepository repo;

    @Override
    public ReminderNotificationsDTO createNotification(ReminderNotificationsDTO dto) {
        return repo.save(dto);
    }

    @Override
    public List<ReminderNotificationsDTO> getAllActiveNotifications() {
        return repo.findByIsActiveTrue();
    }

    @Override
    public void deactivateNotification(Long id) {
        repo.findById(id).ifPresent(notification -> {
            notification.setActive(false);
            repo.save(notification);
        });
    }

    @Override
    @Scheduled(cron = "0 0/1 * * * *") // Every minute for demo
    public void sendScheduledNotifications() {
        LocalDateTime now = LocalDateTime.now();
        List<ReminderNotificationsDTO> all = repo.findAll();

        for (ReminderNotificationsDTO dto : all) {
            if (dto.isActive() && dto.getScheduledTime().isBefore(now)) {
                sendNotificationToPhone(dto.getPhoneNumber(), dto.getMessage());
                dto.setActive(false); // mark as sent
                repo.save(dto);
            }
        }
    }

    @Override
    public void sendNotificationToPhone(String phoneNumber, String message) {
        System.out.println("📲 Sending notification to " + phoneNumber + ": " + message);
    }
}
