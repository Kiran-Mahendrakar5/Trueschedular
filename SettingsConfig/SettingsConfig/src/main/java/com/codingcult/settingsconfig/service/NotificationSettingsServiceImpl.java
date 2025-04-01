package com.codingcult.settingsconfig.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.settingsconfig.dto.NotificationSettingsDTO;
import com.codingcult.settingsconfig.repo.NotificationSettingsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationSettingsServiceImpl implements NotificationSettingsService {

    @Autowired
    private NotificationSettingsRepository notificationSettingsRepository;

    @Override
    public NotificationSettingsDTO saveNotificationSettings(NotificationSettingsDTO notificationSettingsDTO) {
        return notificationSettingsRepository.save(notificationSettingsDTO);
    }

    @Override
    public NotificationSettingsDTO getNotificationSettings(Long userId) {
        return notificationSettingsRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Notification settings not found for user ID: " + userId));
    }

    @Override
    public NotificationSettingsDTO updateNotificationSettings(Long userId, NotificationSettingsDTO notificationSettingsDTO) {
        NotificationSettingsDTO existingSettings = notificationSettingsRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Notification settings not found for user ID: " + userId));

        existingSettings.setNotificationSound(notificationSettingsDTO.isNotificationSound());
        existingSettings.setVibration(notificationSettingsDTO.isVibration());
        existingSettings.setPriority(notificationSettingsDTO.getPriority());
        existingSettings.setNotificationsRead(notificationSettingsDTO.isNotificationsRead());

        return notificationSettingsRepository.save(existingSettings);
    }

    @Override
    public void markNotificationAsRead(Long userId) {
        NotificationSettingsDTO settings = notificationSettingsRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Notification settings not found for user ID: " + userId));

        settings.setNotificationsRead(true);
        notificationSettingsRepository.save(settings);
    }

    @Override
    public List<NotificationSettingsDTO> getAllNotificationSettings() {
        return notificationSettingsRepository.findAll();
    }
}
