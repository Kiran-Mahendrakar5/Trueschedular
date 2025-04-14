package com.codingcult.reminder.service;


import java.util.List;
import java.util.Optional;

import com.codingcult.reminder.dto.EventDto;

public interface EventServiceInterface {

    EventDto createEvent(EventDto eventDto);

    EventDto updateEvent(Long id, EventDto eventDto);

    Optional<EventDto> getEventById(Long id);

    List<EventDto> getAllEvents();

    void deleteEvent(Long id);

    void notifyCalendarAndReminder(EventDto eventDto);

    void sendToFriendService(EventDto eventDto);
}
