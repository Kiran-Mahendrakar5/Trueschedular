package com.codingcult.reminder.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.reminder.dto.PopupNotificationDto;
import com.codingcult.reminder.service.PopupNotificationService;

import java.util.List;

@RestController
@RequestMapping("/popup")
public class PopupNotificationController {

    @Autowired
    private PopupNotificationService service;

    @PostMapping("/trigger")
    public String triggerPopup(@RequestBody PopupNotificationDto dto) {
        return service.triggerPopup(dto);
    }

    @GetMapping("/view/{phone}")
    public List<PopupNotificationDto> getAllByPhone(@PathVariable String phone) {
        return service.getUserNotifications(phone);
    }

    @PutMapping("/status/{id}")
    public String updateStatus(@PathVariable int id, @RequestParam String status) {
        return service.updateStatus(id, status);
    }
    
}
