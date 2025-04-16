package com.codingcult.reminder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codingcult.reminder.dto.NotificationSettingsDto;
import com.codingcult.reminder.dto.PopupNotificationDto;
import com.codingcult.reminder.service.PopupNotificationService;

import java.util.List;

@RestController
@RequestMapping("/popup")
public class PopupNotificationController {

    @Autowired
    private PopupNotificationService service;

    // Trigger from external services like ReminderService, GeoAlertService
    @PostMapping("/trigger-settings")
    public ResponseEntity<String> triggerFromSettings(@RequestBody NotificationSettingsDto notification) {
        service.displayPopup(notification);
        return ResponseEntity.ok("Popup triggered from settings.");
    }

    // Trigger from direct popup DTO (test/internal use)
    @PostMapping("/trigger-direct")
    public ResponseEntity<String> triggerPopup(@RequestBody PopupNotificationDto dto) {
        String result = service.triggerPopup(dto);
        return ResponseEntity.ok(result);
    }

    // View notifications for a specific phone number
    @GetMapping("/view/{phone}")
    public List<PopupNotificationDto> getAllByPhone(@PathVariable String phone) {
        return service.getUserNotifications(phone);
    }

    // Update popup status (SNOOZED, DISMISSED, etc.)
    @PutMapping("/status/{id}")
    public ResponseEntity<String> updateStatus(@PathVariable int id, @RequestParam String status) {
        String result = service.updateStatus(id, status);
        return ResponseEntity.ok(result);
    }
}
