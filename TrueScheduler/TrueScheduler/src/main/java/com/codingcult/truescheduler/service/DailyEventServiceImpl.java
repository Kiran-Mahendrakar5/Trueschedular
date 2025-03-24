package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.DailyEventDto;
import com.codingcult.truescheduler.repo.DailyEventRepository;
import com.codingcult.truescheduler.service.DailyEventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DailyEventServiceImpl implements DailyEventService {

    @Autowired
    private DailyEventRepository eventRepository;

    @Override
    public DailyEventDto createEvent(DailyEventDto eventDto) {
        return eventRepository.save(eventDto);
    }

    @Override
    public List<DailyEventDto> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Optional<DailyEventDto> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public DailyEventDto updateEvent(Long id, DailyEventDto eventDto) {
        Optional<DailyEventDto> existingEvent = eventRepository.findById(id);
        if (existingEvent.isPresent()) {
            DailyEventDto event = existingEvent.get();
            event.setTitle(eventDto.getTitle());
            event.setDescription(eventDto.getDescription());
            event.setEventTime(eventDto.getEventTime());
            event.setAlarmEnabled(eventDto.isAlarmEnabled());
            event.setPaused(eventDto.isPaused());
            event.setStopped(eventDto.isStopped());
            event.setRemindLaterMinutes(eventDto.getRemindLaterMinutes());
            return eventRepository.save(event);
        }
        return null;
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void stopAlarm(Long id) {
        eventRepository.findById(id).ifPresent(event -> {
            event.setStopped(true);
            event.setAlarmEnabled(false);
            eventRepository.save(event);
        });
    }

    @Override
    public void pauseAlarm(Long id) {
        eventRepository.findById(id).ifPresent(event -> {
            event.setPaused(true);
            event.setAlarmEnabled(false);
            eventRepository.save(event);
        });
    }

    @Override
    public void remindLater(Long id, int minutes) {
        eventRepository.findById(id).ifPresent(event -> {
            event.setRemindLaterMinutes(minutes);
            event.setEventTime(event.getEventTime().plusMinutes(minutes));
            eventRepository.save(event);
        });
    }
}
