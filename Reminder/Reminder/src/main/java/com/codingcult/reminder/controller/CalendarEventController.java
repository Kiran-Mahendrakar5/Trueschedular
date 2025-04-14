package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.CalendarEventDto;
import com.codingcult.reminder.service.CalendarEventServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calendar")
public class CalendarEventController {

    @Autowired
    private CalendarEventServiceInterface service;

    @PostMapping("/add")
    public String addEvent(@RequestBody CalendarEventDto dto) {
        return service.addEvent(dto);
    }


    @GetMapping("/{phoneNumber}")
    public List<CalendarEventDto> getEvents(@PathVariable String phoneNumber) {
        return service.getEvents(phoneNumber);
    }
}

