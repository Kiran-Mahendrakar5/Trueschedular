package com.codingcult.reminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.reminder.dto.ReminderDTO;
import com.codingcult.reminder.service.ReminderService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping("/event")
    public ReminderDTO createEventReminder(@RequestBody ReminderDTO reminder) {
        System.out.println("Received Reminder: " + reminder);
        return reminderService.createReminder(reminder);
    }


    // Create a birthday reminder
    @PostMapping("/bday")
    public ReminderDTO createBirthdayReminder(@RequestBody ReminderDTO reminder) {
        return reminderService.createReminder(reminder);
    }

    // Get all reminders
    @GetMapping
    public List<ReminderDTO> getAllReminders() {
        return reminderService.getAllReminders();
    }

    // Get a reminder by ID
    @GetMapping("/{id}")
    public Optional<ReminderDTO> getReminderById(@PathVariable Long id) {
        return reminderService.getReminderById(id);
    }

    // Get reminders by user email
    @GetMapping("/user/{email}")
    public List<ReminderDTO> getRemindersByUser(@PathVariable String email) {
        return reminderService.getRemindersByUser(email);
    }

    // Update a reminder
    @PutMapping("/{id}")
    public ReminderDTO updateReminder(@PathVariable Long id, @RequestBody ReminderDTO updatedReminder) {
        return reminderService.updateReminder(id, updatedReminder);
    }

    // Delete a reminder
    @DeleteMapping("/{id}")
    public void deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
    }
}
