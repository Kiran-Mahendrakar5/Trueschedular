package com.codingcult.truescheduler.service;

import java.util.List;

import com.codingcult.truescheduler.dto.EventDto;

public interface EventService {

	public EventDto saveEvent(EventDto dto);

	public List<EventDto> getAllEvents();

	public EventDto getEventById(Long id);

	public void deleteEvent(Long id);

	public List<EventDto> getReminders();

	public List<EventDto> getEventsByType(String eventType);
}
