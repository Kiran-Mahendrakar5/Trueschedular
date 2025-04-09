package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.ReminderNotificationsDTO;
import com.codingcult.reminder.service.ReminderNotificationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminders")
public class ReminderNotificationsController {

    @Autowired
    private ReminderNotificationsService service;

    @PostMapping("/add")
    public void addNotification(@RequestBody ReminderNotificationsDTO notification) {
        service.createNotification(notification);
    }

    @GetMapping("/all")
    public List<ReminderNotificationsDTO> getAllActive() {
        return service.getAllActiveNotifications();
    }

    @PutMapping("/deactivate/{id}")
    public void deactivate(@PathVariable Long id) {
        service.deactivateNotification(id);
    }
}
