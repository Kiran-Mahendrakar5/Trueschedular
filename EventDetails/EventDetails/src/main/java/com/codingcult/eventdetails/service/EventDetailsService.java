package com.codingcult.eventdetails.service;

import com.codingcult.eventdetails.dto.EventDetailsDTO;

import java.util.List;

public interface EventDetailsService {
    EventDetailsDTO createEvent(EventDetailsDTO event);
    EventDetailsDTO updateEvent(Long id, EventDetailsDTO event);
    boolean deleteEvent(Long id);
    EventDetailsDTO getEventById(Long id);
    List<EventDetailsDTO> getAllEvents();
    List<EventDetailsDTO> getEventsByPhoneNumber(String phoneNumber);
}