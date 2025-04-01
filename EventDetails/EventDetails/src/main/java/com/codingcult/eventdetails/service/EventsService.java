package com.codingcult.eventdetails.service;


import java.util.List;

import com.codingcult.eventdetails.dto.EventsDTO;

public interface EventsService {

    EventsDTO addEvent(EventsDTO eventsDTO);

    List<EventsDTO> getEventsByUser(String userEmail);

    void sendEventReminders();

    String calculateETA(String userLocation, String eventLocation);

    void deleteEvent(Long eventId);
}
