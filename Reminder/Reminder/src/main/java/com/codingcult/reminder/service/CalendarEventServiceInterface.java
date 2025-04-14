package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.CalendarEventDto;

import java.util.List;

public interface CalendarEventServiceInterface {

    String addEvent(CalendarEventDto dto);

    List<CalendarEventDto> getEvents(String phoneNumber);
}
