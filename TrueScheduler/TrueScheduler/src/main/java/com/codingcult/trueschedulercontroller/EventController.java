package com.codingcult.trueschedulercontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.truescheduler.dto.EventDto;
import com.codingcult.truescheduler.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    // Add event
    @PostMapping
    public EventDto addEvent(@RequestBody EventDto eventDTO) {
        return eventService.saveEvent(eventDTO);
    }

    
    @GetMapping
    public List<EventDto> getAllEvents() {
        return eventService.getAllEvents();
    }

    // Get event by ID
    @GetMapping("/{id}")
    public EventDto getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    // Delete event by ID
    @DeleteMapping("/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "Event deleted successfully";
    }

    // Get reminders
    @GetMapping("/reminders")
    public List<EventDto> getReminders() {
        return eventService.getReminders();
    }

    // Get events by type
    @GetMapping("/type/{eventType}")
    public List<EventDto> getEventsByType(@PathVariable String eventType) {
        return eventService.getEventsByType(eventType);
    }
}