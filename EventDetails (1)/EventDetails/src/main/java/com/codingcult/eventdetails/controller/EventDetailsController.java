package com.codingcult.eventdetails.controller;

import com.codingcult.eventdetails.dto.EventDetailsDTO;
import com.codingcult.eventdetails.service.EventDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event-details")
public class EventDetailsController {

    @Autowired
    private EventDetailsService service;

    // Create a new event
    @PostMapping
    public EventDetailsDTO createEvent(@RequestBody EventDetailsDTO dto) {
        return service.createEvent(dto);
    }

    // Update an event
    @PutMapping("/{id}")
    public EventDetailsDTO updateEvent(@PathVariable Long id, @RequestBody EventDetailsDTO dto) {
        return service.updateEvent(id, dto);
    }

    // Soft delete an event
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        boolean deleted = service.deleteEvent(id);
        return deleted ? "Event soft deleted successfully" : "Event not found";
    }

    // Get event by ID
    @GetMapping("/{id}")
    public EventDetailsDTO getEventById(@PathVariable Long id) {
        EventDetailsDTO dto = service.getEventById(id);
        return (dto != null && dto.isActive()) ? dto : null;
    }

    // Get all active events
    @GetMapping
    public List<EventDetailsDTO> getAllEvents() {
        return service.getAllEvents();
    }

    // Get events by phone number
    @GetMapping("/phone/{phoneNumber}")
    public List<EventDetailsDTO> getEventsByPhoneNumber(@PathVariable String phoneNumber) {
        return service.getEventsByPhoneNumber(phoneNumber);
    }
}
