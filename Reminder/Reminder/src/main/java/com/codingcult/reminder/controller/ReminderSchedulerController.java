package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.ReminderSchedulerDto;
import com.codingcult.reminder.service.ReminderSchedulerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminderScheduler")
public class ReminderSchedulerController {

    @Autowired
    private ReminderSchedulerService schedulerService;

    @PostMapping("/add")
    public String addSchedule(@RequestBody ReminderSchedulerDto dto) {
        schedulerService.addSchedule(dto);
        return "Reminder schedule added successfully.";
    }

    @GetMapping("/all")
    public List<ReminderSchedulerDto> getAll() {
        return schedulerService.getAllActiveSchedules();
    }
}
