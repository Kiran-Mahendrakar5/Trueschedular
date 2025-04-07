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
    public NotificationSettingsDTO getNotificationSettings(String phoneNumber) {
        return notificationSettingsRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Notification settings not found for phone number: " + phoneNumber));
    }

    @Override
    public NotificationSettingsDTO updateNotificationSettings(String phoneNumber, NotificationSettingsDTO notificationSettingsDTO) {
        NotificationSettingsDTO existingSettings = notificationSettingsRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Notification settings not found for phone number: " + phoneNumber));

        existingSettings.setNotificationSound(notificationSettingsDTO.isNotificationSound());
        existingSettings.setVibration(notificationSettingsDTO.isVibration());
        existingSettings.setPriority(notificationSettingsDTO.getPriority());
        existingSettings.setNotificationsRead(notificationSettingsDTO.isNotificationsRead());
        existingSettings.setActive(notificationSettingsDTO.isActive());

        return notificationSettingsRepository.save(existingSettings);
    }

    @Override
    public void markNotificationAsRead(String phoneNumber) {
        NotificationSettingsDTO settings = notificationSettingsRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("Notification settings not found for phone number: " + phoneNumber));

        settings.setNotificationsRead(true);
        notificationSettingsRepository.save(settings);
    }

    @Override
    public List<NotificationSettingsDTO> getAllNotificationSettings() {
        return notificationSettingsRepository.findAll();
    }
}