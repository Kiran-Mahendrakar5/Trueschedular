package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.EventDto;
import com.codingcult.truescheduler.repo.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public EventDto saveEvent(EventDto dto) {
        return eventRepository.save(dto);
    }

    @Override
    public List<EventDto> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public EventDto getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Event not found with ID: " + id));
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public List<EventDto> getReminders() {
        return eventRepository.findByReminderSetTrue();
    }

    @Override
    public List<EventDto> getEventsByType(String eventType) {
        return eventRepository.findByEventType(eventType);
    }
}
