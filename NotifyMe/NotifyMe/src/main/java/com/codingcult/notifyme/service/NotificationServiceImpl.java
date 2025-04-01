package com.codingcult.notifyme.service;

import com.codingcult.notifyme.dto.NotificationDto;
import com.codingcult.notifyme.repo.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private JavaMailSender mailSender; // For sending emails

    @Override
    public NotificationDto scheduleNotification(NotificationDto notificationDto) {
        return notificationRepository.save(notificationDto);
    }

    @Override
    @Scheduled(fixedRate = 60000) // Runs every 1 minute
    public void sendNotifications() {
        List<NotificationDto> dueNotifications = notificationRepository.findByEventTimeBefore(LocalDateTime.now());

        for (NotificationDto notification : dueNotifications) {
            if ("EMAIL".equalsIgnoreCase(notification.getNotificationType())) {
                sendEmailNotification(notification.getUserEmail(), notification.getMessage());
            }
            // You can add push and SMS notification handling here.
        }

        // Remove sent notifications from DB
        notificationRepository.deleteAll(dueNotifications);
    }

    private void sendEmailNotification(String email, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email);
        mailMessage.setSubject("Event Reminder / Offer Alert");
        mailMessage.setText(message);
        mailSender.send(mailMessage);
    }
}
