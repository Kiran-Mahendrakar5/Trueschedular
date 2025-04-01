package com.codingcult.eventdetails.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.eventdetails.dto.EventsDTO;
import com.codingcult.eventdetails.service.EventsService;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @PostMapping
    public EventsDTO addEvent(@RequestBody EventsDTO eventsDTO) {
        return eventsService.addEvent(eventsDTO);
    }

    @GetMapping("/{userEmail}")
    public List<EventsDTO> getEventsByUser(@PathVariable String userEmail) {
        return eventsService.getEventsByUser(userEmail);
    }

    @GetMapping("/eta")
    public String calculateETA(@RequestParam String userLocation, @RequestParam String eventLocation) {
        return eventsService.calculateETA(userLocation, eventLocation);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventsService.deleteEvent(id);
        return "Event deleted successfully!";
    }
}
