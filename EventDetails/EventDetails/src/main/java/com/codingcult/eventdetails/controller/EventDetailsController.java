package com.codingcult.eventdetails.controller;

import com.codingcult.eventdetails.dto.EventDetailsDTO;
import com.codingcult.eventdetails.service.EventDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/eventdetails")
public class EventDetailsController {

    @Autowired
    private EventDetailsService service;

    @PostMapping
    public ResponseEntity<EventDetailsDTO> createEvent(@RequestBody EventDetailsDTO dto) {
        return ResponseEntity.ok(service.createEvent(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EventDetailsDTO> updateEvent(@PathVariable Long id, @RequestBody EventDetailsDTO dto) {
        return ResponseEntity.ok(service.updateEvent(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id) {
        boolean deleted = service.deleteEvent(id);
        return deleted ? ResponseEntity.ok("Deleted successfully") : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<EventDetailsDTO>> getAllEvents() {
        return ResponseEntity.ok(service.getAllEvents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventDetailsDTO> getEventById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEventById(id));
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<List<EventDetailsDTO>> getEventsByPhoneNumber(@PathVariable String phoneNumber) {
        return ResponseEntity.ok(service.getEventsByPhoneNumber(phoneNumber));
    }
}
