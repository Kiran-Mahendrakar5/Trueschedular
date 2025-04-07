package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.ReminderDTO;
import com.codingcult.reminder.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @PostMapping("/event")
    public ReminderDTO createEventReminder(@RequestBody ReminderDTO reminder) {
        return reminderService.createReminder(reminder);
    }

    @PostMapping("/bday")
    public ReminderDTO createBirthdayReminder(@RequestBody ReminderDTO reminder) {
        return reminderService.createReminder(reminder);
    }

    @GetMapping
    public List<ReminderDTO> getAllReminders() {
        return reminderService.getAllReminders();
    }

    @GetMapping("/{id}")
    public Optional<ReminderDTO> getReminderById(@PathVariable Long id) {
        return reminderService.getReminderById(id);
    }

    @GetMapping("/phone/{phoneNumber}")
    public List<ReminderDTO> getRemindersByPhone(@PathVariable String phoneNumber) {
        return reminderService.getRemindersByPhone(phoneNumber);
    }

    @PutMapping("/{id}")
    public ReminderDTO updateReminder(@PathVariable Long id, @RequestBody ReminderDTO updatedReminder) {
        return reminderService.updateReminder(id, updatedReminder);
    }

    @DeleteMapping("/{id}")
    public void deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
    }
}
