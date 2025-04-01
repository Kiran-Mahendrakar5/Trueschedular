package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.ReminderNotificationsDTO;
import com.codingcult.reminder.service.ReminderNotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class ReminderNotificationsController {

    @Autowired
    private ReminderNotificationsService reminderNotificationsService;

    @PostMapping
    public ReminderNotificationsDTO createNotification(@RequestBody ReminderNotificationsDTO reminderNotificationsDTO) {
        return reminderNotificationsService.createNotification(reminderNotificationsDTO);
    }

    @GetMapping("/{userEmail}")
    public List<ReminderNotificationsDTO> getNotificationsByUser(@PathVariable String userEmail) {
        return reminderNotificationsService.getNotificationsByUser(userEmail);
    }

    @GetMapping("/type/{notificationType}")
    public List<ReminderNotificationsDTO> getNotificationsByType(@PathVariable String notificationType) {
        return reminderNotificationsService.getNotificationsByType(notificationType);
    }

    @DeleteMapping("/{id}")
    public String deleteNotification(@PathVariable Long id) {
        reminderNotificationsService.deleteNotification(id);
        return "Notification deleted successfully!";
    }
}
