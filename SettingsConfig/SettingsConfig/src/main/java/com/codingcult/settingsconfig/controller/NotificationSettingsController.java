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

    @GetMapping("/{phoneNumber}")
    public NotificationSettingsDTO getNotificationSettings(@PathVariable String phoneNumber) {
        return notificationSettingsService.getNotificationSettings(phoneNumber);
    }

    @PutMapping("/{phoneNumber}")
    public NotificationSettingsDTO updateNotificationSettings(@PathVariable String phoneNumber, @RequestBody NotificationSettingsDTO notificationSettingsDTO) {
        return notificationSettingsService.updateNotificationSettings(phoneNumber, notificationSettingsDTO);
    }

    @PutMapping("/{phoneNumber}/read")
    public void markNotificationAsRead(@PathVariable String phoneNumber) {
        notificationSettingsService.markNotificationAsRead(phoneNumber);
    }

    @GetMapping
    public List<NotificationSettingsDTO> getAllNotificationSettings() {
        return notificationSettingsService.getAllNotificationSettings();
    }
}