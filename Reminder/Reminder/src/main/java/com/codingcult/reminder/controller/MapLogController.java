package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.MapLogDto;
import com.codingcult.reminder.service.MapLogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/map-log")
public class MapLogController {

    @Autowired
    private MapLogServiceInterface mapLogService;

    @PostMapping("/log")
    public String logLocation(@RequestBody MapLogDto mapLogDto) {
        return mapLogService.logLocation(mapLogDto);
    }

    @GetMapping("/history/{phoneNumber}")
    public List<MapLogDto> getLocationHistory(@PathVariable String phoneNumber) {
        return mapLogService.getLocationHistory(phoneNumber);
    }

    @GetMapping("/history-range")
    public List<MapLogDto> getLocationHistoryByRange(
            @RequestParam String phoneNumber,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return mapLogService.getLocationHistoryByRange(phoneNumber, start, end);
    }
}
