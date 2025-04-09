package com.codingcult.notifyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.codingcult.notifyme.dto.NotificationDto;
import com.codingcult.notifyme.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/schedule")
    public NotificationDto scheduleNotification(@RequestBody NotificationDto notificationDto) {
        return notificationService.scheduleNotification(notificationDto);
    }
}