package com.codingcult.settingsconfig.service;

import java.util.List;
import com.codingcult.settingsconfig.dto.NotificationSettingsDTO;

public interface NotificationSettingsService {
    NotificationSettingsDTO saveNotificationSettings(NotificationSettingsDTO notificationSettingsDTO);
    NotificationSettingsDTO getNotificationSettings(String phoneNumber);
    NotificationSettingsDTO updateNotificationSettings(String phoneNumber, NotificationSettingsDTO notificationSettingsDTO);
    void markNotificationAsRead(String phoneNumber);
    List<NotificationSettingsDTO> getAllNotificationSettings();
}
