package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.AlarmDTO;
import com.codingcult.reminder.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alarms")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @PostMapping
    public AlarmDTO createAlarm(@RequestBody AlarmDTO alarmDTO) {
        return alarmService.createAlarm(alarmDTO);
    }

    @GetMapping("/{phoneNumber}")
    public List<AlarmDTO> getAlarmsByPhone(@PathVariable String phoneNumber) {
        return alarmService.getAlarmsByPhoneNumber(phoneNumber);
    }

    @PatchMapping("/stop/{id}")
    public String stopAlarm(@PathVariable Long id) {
        alarmService.stopAlarm(id);
        return "Alarm stopped successfully!";
    }

    @PatchMapping("/pause/{id}")
    public String pauseAlarm(@PathVariable Long id) {
        alarmService.pauseAlarm(id);
        return "Alarm paused successfully!";
    }

    @PatchMapping("/remind-later/{id}")
    public String remindLater(@PathVariable Long id) {
        alarmService.remindLater(id);
        return "Reminder set for later!";
    }
}
