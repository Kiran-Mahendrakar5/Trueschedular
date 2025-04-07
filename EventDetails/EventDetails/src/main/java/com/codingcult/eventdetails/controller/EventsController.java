package com.codingcult.eventdetails.controller;

import com.codingcult.eventdetails.dto.EventsDTO;
import com.codingcult.eventdetails.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @PostMapping
    public EventsDTO addEvent(@RequestBody EventsDTO eventsDTO) {
        return eventsService.save(eventsDTO);
    }

    @GetMapping("/{phoneNumber}")
    public List<EventsDTO> getEventsByUser(@PathVariable String phoneNumber) {
        return eventsService.getByPhoneNumber(phoneNumber);
    }

    @GetMapping
    public List<EventsDTO> getAllEvents() {
        return eventsService.getAll();
    }

    @PutMapping("/{id}")
    public EventsDTO updateEvent(@PathVariable Long id, @RequestBody EventsDTO dto) {
        return eventsService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        boolean deleted = eventsService.delete(id);
        return deleted ? "Event deleted successfully!" : "Event not found!";
    }
}