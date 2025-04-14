package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.NotificationSettingsDto;

public interface NotificationSettingsServiceInterface {

    String saveNotificationSettings(NotificationSettingsDto settingsDto);

    NotificationSettingsDto getNotificationSettings(String phoneNumber);

    String updateNotificationSettings(NotificationSettingsDto settingsDto);
}
