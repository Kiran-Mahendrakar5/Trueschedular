package com.codingcult.eventdetails.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.eventdetails.dto.EventDetailsDTO;
import com.codingcult.eventdetails.service.EventDetailsService;

import java.util.List;

@RestController
@RequestMapping("/api/events_details")
public class EventDetailsController {

    @Autowired
    private EventDetailsService eventDetailsService;

    @PostMapping
    public EventDetailsDTO createEvent(@RequestBody EventDetailsDTO eventDetailsDTO) {
        return eventDetailsService.createEvent(eventDetailsDTO);
    }

    @GetMapping("/{userEmail}")
    public List<EventDetailsDTO> getEventsByUser(@PathVariable String userEmail) {
        return eventDetailsService.getEventsByUser(userEmail);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventDetailsService.deleteEvent(id);
        return "Event deleted successfully!";
    }
}
