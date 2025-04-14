package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.ActivityLogDto;
import com.codingcult.reminder.service.ActivityLogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activity-log")
public class ActivityLogController {

    @Autowired
    private ActivityLogServiceInterface logService;

    @PostMapping("/log")
    public String logAction(@RequestBody ActivityLogDto logDto) {
        return logService.logAction(logDto);
    }

    @GetMapping("/{phoneNumber}")
    public List<ActivityLogDto> getAllLogs(@PathVariable String phoneNumber) {
        return logService.getAllLogs(phoneNumber);
    }

    @GetMapping("/{phoneNumber}/filter")
    public List<ActivityLogDto> getLogsByActionType(
            @PathVariable String phoneNumber,
            @RequestParam String actionType) {
        return logService.getLogsByActionType(phoneNumber, actionType);
    }
}
