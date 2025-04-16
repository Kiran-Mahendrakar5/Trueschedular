package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.CalendarEventDto;
import com.codingcult.reminder.dto.DailyScheduleAlarmDto;
import com.codingcult.reminder.dto.ReminderDto;
import com.codingcult.reminder.feign.ReminderServiceClient;
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
    
    @GetMapping("/reminders/user/{phoneNumber}")
    public List<ReminderDto> getUserReminders(@PathVariable String phoneNumber) {
        return service.getRemindersByPhoneNumber(phoneNumber); 
    }


    
    @GetMapping("/user/{phoneNumber}")
    public List<ReminderDto> getRemindersByPhoneNumber(@PathVariable String phoneNumber) {
        // Fetch data from DB or service
        return service.getRemindersByPhoneNumber(phoneNumber);
    }
    
    @PostMapping("/friendsave")
    public ResponseEntity<String> createFriendReminder(@RequestBody ReminderDto dto) {
        service.saveReminder(dto);
        return ResponseEntity.ok("Friend reminder saved successfully.");
    }
    @GetMapping("/active")
    public ResponseEntity<List<ReminderDto>> getActiveReminders() {
        List<ReminderDto> activeReminders = service.getAllActiveReminders();
        return new ResponseEntity<>(activeReminders, HttpStatus.OK);
    }

    
 

    @PostMapping("/from-calendar")
    public ResponseEntity<String> createReminderFromCalendar(@RequestBody CalendarEventDto event) {
        // Handle the reminder creation
        System.out.println("Received event for reminder: " + event);
        return ResponseEntity.ok("Reminder created successfully.");
    
    }
    @PostMapping
    public ResponseEntity<String> triggerReminder(@RequestBody ReminderDto dto) {
        service.saveReminder(dto);
        return ResponseEntity.ok("Reminder triggered successfully.");
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
