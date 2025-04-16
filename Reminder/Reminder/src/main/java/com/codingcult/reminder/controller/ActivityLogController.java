package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.ActivityLogDto;
import com.codingcult.reminder.service.ActivityLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-logs")
public class ActivityLogController {

    @Autowired
    private ActivityLogService activityLogService;

    @PostMapping
    public String logAction(@RequestBody ActivityLogDto logDto) {
        return activityLogService.logAction(logDto);
    }

    @GetMapping("/user/{phoneNumber}")
    public List<ActivityLogDto> getAllLogs(@PathVariable String phoneNumber) {
        return activityLogService.getAllLogs(phoneNumber);
    }

    @GetMapping("/user/{phoneNumber}/action/{actionType}")
    public List<ActivityLogDto> getLogsByActionType(@PathVariable String phoneNumber, @PathVariable String actionType) {
        return activityLogService.getLogsByActionType(phoneNumber, actionType);
    }
}
