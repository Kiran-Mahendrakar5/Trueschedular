package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.AlarmDTO;
import com.codingcult.reminder.service.AlarmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/alarms")
public class AlarmController {

    @Autowired
    private AlarmService alarmService;

    @PostMapping
    public ResponseEntity<AlarmDTO> createAlarm(@RequestBody AlarmDTO alarmDTO) {
        return new ResponseEntity<>(alarmService.createAlarm(alarmDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{userEmail}")
    public ResponseEntity<List<AlarmDTO>> getAlarmsByUser(@PathVariable String userEmail) {
        List<AlarmDTO> alarms = alarmService.getAllAlarmsByUser(userEmail);
        return new ResponseEntity<>(alarms, HttpStatus.OK);
    }

    @PatchMapping("/stop/{id}")
    public ResponseEntity<String> stopAlarm(@PathVariable Long id) {
        alarmService.stopAlarm(id);
        return new ResponseEntity<>("Alarm stopped successfully!", HttpStatus.OK);
    }

    @PatchMapping("/pause/{id}")
    public ResponseEntity<String> pauseAlarm(@PathVariable Long id) {
        alarmService.pauseAlarm(id);
        return new ResponseEntity<>("Alarm paused successfully!", HttpStatus.OK);
    }

    @PatchMapping("/remind-later/{id}")
    public ResponseEntity<String> remindLater(@PathVariable Long id) {
        alarmService.remindLater(id);
        return new ResponseEntity<>("Reminder set for later!", HttpStatus.OK);
    }
}
