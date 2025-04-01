package com.codingcult.eventdetails.service;

import java.util.List;

import com.codingcult.eventdetails.dto.EventDetailsDTO;

public interface EventDetailsService {

    EventDetailsDTO createEvent(EventDetailsDTO eventDetailsDTO);

    List<EventDetailsDTO> getEventsByUser(String userEmail);

    void sendEventNotifications();

    void syncWithExternalCalendars();

    void deleteEvent(Long eventId);
}
