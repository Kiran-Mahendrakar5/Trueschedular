package com.codingcult.reminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.reminder.dto.EventDto;
import com.codingcult.reminder.service.EventServiceInterface;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventServiceInterface eventService;

    @Autowired
    public EventController(EventServiceInterface eventService) {
        this.eventService = eventService;
    }

    @PostMapping
    public EventDto createEvent(@RequestBody EventDto eventDto) {
        return eventService.createEvent(eventDto);
    }

    @PutMapping("/{id}")
    public EventDto updateEvent(@PathVariable Long id, @RequestBody EventDto eventDto) {
        EventDto updatedEvent = eventService.updateEvent(id, eventDto);
        if (updatedEvent != null) {
            return updatedEvent;
        }
        return null;  // You can handle this case by returning a 404 or other appropriate response code in a real-world scenario.
    }

    @GetMapping("/{id}")
    public EventDto getEventById(@PathVariable Long id) {
        Optional<EventDto> event = eventService.getEventById(id);
        return event.orElse(null);  // Return null if event not found
    }

    @GetMapping
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
    }
}
