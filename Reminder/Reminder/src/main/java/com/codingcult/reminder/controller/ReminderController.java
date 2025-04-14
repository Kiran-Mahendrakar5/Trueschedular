package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.CalendarEventDto;
import com.codingcult.reminder.dto.ReminderDto;
import com.codingcult.reminder.service.ReminderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    @Autowired
    private ReminderService service;

    @PostMapping("/from-calendar")
    public ResponseEntity<String> createReminderFromCalendar(@RequestBody CalendarEventDto event) {
        // Handle the reminder creation
        System.out.println("Received event for reminder: " + event);
        return ResponseEntity.ok("Reminder created successfully.");
    
    }


    @GetMapping("/all")
    public List<ReminderDto> getAllReminders() {
        return service.getAllActiveReminders();
    }

    @GetMapping("/category/{category}")
    public List<ReminderDto> getByCategory(@PathVariable String category) {
        return service.getRemindersByCategory(category);
    }
}
