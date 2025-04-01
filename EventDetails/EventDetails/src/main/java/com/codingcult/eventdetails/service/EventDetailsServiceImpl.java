package com.codingcult.eventdetails.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.codingcult.eventdetails.dto.EventDetailsDTO;
import com.codingcult.eventdetails.repo.EventDetailsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventDetailsServiceImpl implements EventDetailsService {

    @Autowired
    private EventDetailsRepository eventDetailsRepository;

    @Override
    public EventDetailsDTO createEvent(EventDetailsDTO eventDetailsDTO) {
        return eventDetailsRepository.save(eventDetailsDTO);
    }

    @Override
    public List<EventDetailsDTO> getEventsByUser(String userEmail) {
        return eventDetailsRepository.findByUserEmail(userEmail);
    }

    @Override
    @Scheduled(cron = "0 0 8 * * *") // Run daily at 8 AM
    public void sendEventNotifications() {
        LocalDateTime now = LocalDateTime.now();

        List<EventDetailsDTO> events = eventDetailsRepository.findByEventStartTimeBetween(now, now.plusHours(1));

        for (EventDetailsDTO event : events) {
            if (event.getNotificationEnabled()) {
                sendNotification(event);
            }
        }
    }

    private void sendNotification(EventDetailsDTO event) {
        System.out.println("🔔 Event Reminder: " + event.getEventTitle() + " at " + event.getEventStartTime());
        // Implement real push/email notifications here
    }

    @Override
    public void syncWithExternalCalendars() {
        System.out.println("🔄 Syncing events with external calendars...");
        // Implement Google Calendar or Outlook API integration
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventDetailsRepository.deleteById(eventId);
    }
}
