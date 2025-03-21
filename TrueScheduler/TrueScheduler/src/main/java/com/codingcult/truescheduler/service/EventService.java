package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.EventDto;

import java.util.List;

public interface EventService {

   public  EventDto saveEvent(EventDto dto);

   public List<EventDto> getAllEvents();

   public EventDto getEventById(Long id);

   public  void deleteEvent(Long id);

   public  List<EventDto> getReminders();
}
