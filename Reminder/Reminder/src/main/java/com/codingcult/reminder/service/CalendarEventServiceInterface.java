package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.CalendarEventDto;
import com.codingcult.reminder.dto.EventDto;

import java.util.List;

public interface CalendarEventServiceInterface {

    String addEvent(CalendarEventDto dto);

    List<CalendarEventDto> getEvents(String phoneNumber);

	String createEventAndRemind(EventDto dto);
}
