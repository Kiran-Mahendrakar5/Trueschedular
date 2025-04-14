package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.NotificationSettingsDto;
import com.codingcult.reminder.repo.NotificationSettingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationSettingsService implements NotificationSettingsServiceInterface {

    @Autowired
    private NotificationSettingsRepository settingsRepository;

    @Override
    public String saveNotificationSettings(NotificationSettingsDto settingsDto) {
        settingsRepository.save(settingsDto);
        return "Notification settings saved successfully!";
    }

    @Override
    public NotificationSettingsDto getNotificationSettings(String phoneNumber) {
        return settingsRepository.findByUserPhoneNumber(phoneNumber);
    }

    @Override
    public String updateNotificationSettings(NotificationSettingsDto settingsDto) {
        NotificationSettingsDto existingSettings = settingsRepository.findByUserPhoneNumber(settingsDto.getUserPhoneNumber());
        if (existingSettings != null) {
            existingSettings.setTone(settingsDto.getTone());
            existingSettings.setSnoozeEnabled(settingsDto.isSnoozeEnabled());
            existingSettings.setSnoozeDuration(settingsDto.getSnoozeDuration());
            existingSettings.setPriority(settingsDto.getPriority());
            settingsRepository.save(existingSettings);
            return "Notification settings updated successfully!";
        }
        return "Notification settings not found for this user!";
    }
}
