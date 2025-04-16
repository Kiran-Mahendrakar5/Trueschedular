package com.codingcult.reminder.controller;


import com.codingcult.reminder.dto.DailyScheduleAlarmDto;
import com.codingcult.reminder.dto.ReminderDto;
import com.codingcult.reminder.dto.ReminderSchedulerDto;
import com.codingcult.reminder.feign.ReminderServiceClient;
import com.codingcult.reminder.service.ReminderSchedulerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reminderScheduler")
public class ReminderSchedulerController {

    @Autowired
    private ReminderSchedulerService schedulerService;
    
    @Autowired
    private ReminderServiceClient reminderClient;
    
    
    @PostMapping("/addDaily") // Final path: /reminderScheduler/addDaily
    public String scheduleDailyAlarm(@RequestBody DailyScheduleAlarmDto dto) {
        return reminderClient.addDailySchedule(dto); // Feign client hits /dailySchedule/add
    }
   

    @PostMapping("/set-reminder")
    public ResponseEntity<String> scheduleReminder(@RequestBody ReminderDto dto) {
        String preview = reminderClient.triggerReminder(dto);
        return ResponseEntity.ok(preview);
    }

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
