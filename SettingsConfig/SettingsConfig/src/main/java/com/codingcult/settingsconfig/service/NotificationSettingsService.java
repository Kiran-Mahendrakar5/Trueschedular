package com.codingcult.settingsconfig.service;



import java.util.List;

import com.codingcult.settingsconfig.dto.NotificationSettingsDTO;

public interface NotificationSettingsService {

    NotificationSettingsDTO saveNotificationSettings(NotificationSettingsDTO notificationSettingsDTO);
    NotificationSettingsDTO getNotificationSettings(Long userId);
    NotificationSettingsDTO updateNotificationSettings(Long userId, NotificationSettingsDTO notificationSettingsDTO);
    void markNotificationAsRead(Long userId);
    List<NotificationSettingsDTO> getAllNotificationSettings();
}
