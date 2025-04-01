package com.codingcult.settingsconfig.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.settingsconfig.dto.NotificationSettingsDTO;
import com.codingcult.settingsconfig.service.NotificationSettingsService;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationSettingsController {

    @Autowired
    private NotificationSettingsService notificationSettingsService;

    @PostMapping
    public NotificationSettingsDTO saveNotificationSettings(@RequestBody NotificationSettingsDTO notificationSettingsDTO) {
        return notificationSettingsService.saveNotificationSettings(notificationSettingsDTO);
    }

    @GetMapping("/{userId}")
    public NotificationSettingsDTO getNotificationSettings(@PathVariable Long userId) {
        return notificationSettingsService.getNotificationSettings(userId);
    }

    @PutMapping("/{userId}")
    public NotificationSettingsDTO updateNotificationSettings(@PathVariable Long userId, @RequestBody NotificationSettingsDTO notificationSettingsDTO) {
        return notificationSettingsService.updateNotificationSettings(userId, notificationSettingsDTO);
    }

    @PutMapping("/{userId}/read")
    public void markNotificationAsRead(@PathVariable Long userId) {
        notificationSettingsService.markNotificationAsRead(userId);
    }

    @GetMapping
    public List<NotificationSettingsDTO> getAllNotificationSettings() {
        return notificationSettingsService.getAllNotificationSettings();
    }
}
