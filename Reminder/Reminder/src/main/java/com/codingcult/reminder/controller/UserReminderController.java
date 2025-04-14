package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.UserReminderDto;
import com.codingcult.reminder.service.UserReminderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userReminder")
public class UserReminderController {

    @Autowired
    private UserReminderService service;

    @PostMapping("/add")
    public String addReminder(@RequestBody UserReminderDto dto) {
        return service.addUserReminder(dto);
    }

    @GetMapping("/all")
    public List<UserReminderDto> getAll() {
        return service.getAllReminders();
    }
}
