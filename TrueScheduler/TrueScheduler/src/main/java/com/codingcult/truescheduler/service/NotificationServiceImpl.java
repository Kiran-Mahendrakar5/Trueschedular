package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.NotificationDTO;
import com.codingcult.truescheduler.repo.NotificationRepository;
import com.codingcult.truescheduler.service.NotificationService;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public NotificationDTO saveNotification(NotificationDTO notificationDTO) {
        return notificationRepository.save(notificationDTO);
    }

    @Override
    public NotificationDTO getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Notification not found with ID: " + id));
    }

    @Override
    public List<NotificationDTO> getAllNotifications() {
        return notificationRepository.findAll();
    }

    @Override
    public List<NotificationDTO> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }

    @Override
    public NotificationDTO updateNotification(Long id, NotificationDTO notificationDTO) {
        NotificationDTO existingNotification = getNotificationById(id);

        existingNotification.setUserId(notificationDTO.getUserId());
        existingNotification.setEventId(notificationDTO.getEventId());
        existingNotification.setMessage(notificationDTO.getMessage());
        existingNotification.setNotificationTime(notificationDTO.getNotificationTime());
        existingNotification.setStatus(notificationDTO.getStatus());

        return notificationRepository.save(existingNotification);
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}
