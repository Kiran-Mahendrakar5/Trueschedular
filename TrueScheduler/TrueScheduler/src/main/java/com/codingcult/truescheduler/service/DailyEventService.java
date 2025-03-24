package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.DailyEventDto;
import java.util.List;
import java.util.Optional;

public interface DailyEventService {

	public DailyEventDto createEvent(DailyEventDto eventDto);

	public List<DailyEventDto> getAllEvents();

	public Optional<DailyEventDto> getEventById(Long id);

	public DailyEventDto updateEvent(Long id, DailyEventDto eventDto);

	public void deleteEvent(Long id);

	public void stopAlarm(Long id);

	public void pauseAlarm(Long id);

	public void remindLater(Long id, int minutes);
}
