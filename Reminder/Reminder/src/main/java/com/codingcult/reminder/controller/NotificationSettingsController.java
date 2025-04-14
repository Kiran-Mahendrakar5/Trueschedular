package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.NotificationSettingsDto;
import com.codingcult.reminder.service.NotificationSettingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notification-settings")
public class NotificationSettingsController {

    @Autowired
    private NotificationSettingsService notificationSettingsService;

    // Endpoint to get notification settings for a user
    @GetMapping("/{phoneNumber}")
    public NotificationSettingsDto getNotificationSettings(@PathVariable String phoneNumber) {
        return notificationSettingsService.getNotificationSettings(phoneNumber);
    }

    // Endpoint to save new notification settings for a user
    @PostMapping("/save")
    public String saveNotificationSettings(@RequestBody NotificationSettingsDto settingsDto) {
        return notificationSettingsService.saveNotificationSettings(settingsDto);
    }

    // Endpoint to update existing notification settings
    @PutMapping("/update")
    public String updateNotificationSettings(@RequestBody NotificationSettingsDto settingsDto) {
        return notificationSettingsService.updateNotificationSettings(settingsDto);
    }
}
