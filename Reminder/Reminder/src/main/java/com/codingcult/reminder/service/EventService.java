package com.codingcult.reminder.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.reminder.dto.EventDto;
import com.codingcult.reminder.feign.CalendarServiceClient;
import com.codingcult.reminder.feign.FriendServiceClient;
import com.codingcult.reminder.feign.ReminderServiceClient;
import com.codingcult.reminder.repo.EventRepository;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventServiceInterface {

    private final EventRepository eventRepository;
    
    @Autowired
    private CalendarServiceClient calendarClient;

    @Autowired
    private ReminderServiceClient reminderClient;

    @Autowired
    private FriendServiceClient friendClient;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }
    
    // Method to create or update events
    public String createOrUpdateEvent(EventDto eventDto) {
        // Process event creation or update logic here
        
        // Notify Calendar Service
        String calendarResponse = calendarClient.updateEvent(eventDto);
        
        // Notify Reminder Service
        String reminderResponse = reminderClient.createReminder(eventDto);
        
        // If event is a birthday, notify Friend Service
        if (eventDto.getTitle().equals("Birthday")) {
            String friendResponse = friendClient.sendBirthdayData(eventDto);
        }
        
        // Return response after event handling
        return "Event created or updated and notifications sent.";
    }


    @Override
    public EventDto createEvent(EventDto eventDto) {
        // Logic for creating an event
        EventDto savedEvent = eventRepository.save(eventDto);

        // Notify calendar, reminder, and friend service if needed
        if (eventDto.isSendToCalendar()) {
            notifyCalendarAndReminder(eventDto);
        }
        if (eventDto.isSendToReminder()) {
            notifyCalendarAndReminder(eventDto);
        }
        if (eventDto.isSendToFriendService()) {
            sendToFriendService(eventDto);
        }

        return savedEvent;
    }

    @Override
    public EventDto updateEvent(Long id, EventDto eventDto) {
        Optional<EventDto> existingEvent = eventRepository.findById(id);
        if (existingEvent.isPresent()) {
            eventDto.setId(id);
            return eventRepository.save(eventDto);
        }
        return null; // Return null if event doesn't exist
    }

    @Override
    public Optional<EventDto> getEventById(Long id) {
        return eventRepository.findById(id);
    }

    @Override
    public List<EventDto> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    @Override
    public void notifyCalendarAndReminder(EventDto eventDto) {
        // Logic for sending notifications to Calendar and Reminder Service
        // Implement your logic here (e.g., call external services via RestTemplate or Feign)
    }

    @Override
    public void sendToFriendService(EventDto eventDto) {
        // Logic for sending event to FriendService (Birthday Data, etc.)
        // Implement your logic here (e.g., call FriendService)
    }
}
