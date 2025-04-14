package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.DailyScheduleAlarmDto;
import com.codingcult.reminder.service.DailyScheduleAlarmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dailySchedule")
public class DailyScheduleAlarmController {

    @Autowired
    private DailyScheduleAlarmService service;

    @PostMapping("/add")
    public String add(@RequestBody DailyScheduleAlarmDto dto) {
        return service.addAlarm(dto);
    }

    @GetMapping("/all")
    public List<DailyScheduleAlarmDto> getAll() {
        return service.getAllAlarms();
    }
}
