package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.MapLogDto;
import com.codingcult.reminder.service.MapLogServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
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
    public List<MapLogDto> getLocationHistoryByRange(@RequestParam String phoneNumber,
                                                      @RequestParam String start,
                                                      @RequestParam String end) {
        try {
            LocalDateTime startTime = LocalDateTime.parse(start);
            LocalDateTime endTime = LocalDateTime.parse(end);

            return mapLogService.getLocationHistoryByRange(phoneNumber, startTime, endTime);
        } catch (DateTimeParseException e) {
            // Handle invalid date format error
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Expected format: yyyy-MM-dd'T'HH:mm:ss");
        } catch (Exception e) {
            // General error handling
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request: " + e.getMessage());
        }
    }



}
