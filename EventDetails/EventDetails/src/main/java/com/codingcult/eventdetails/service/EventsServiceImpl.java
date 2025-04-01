package com.codingcult.eventdetails.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.codingcult.eventdetails.dto.EventsDTO;
import com.codingcult.eventdetails.repo.EventsRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Override
    public EventsDTO addEvent(EventsDTO eventsDTO) {
        return eventsRepository.save(eventsDTO);
    }

    @Override
    public List<EventsDTO> getEventsByUser(String userEmail) {
        return eventsRepository.findByUserEmail(userEmail);
    }

    @Override
    @Scheduled(cron = "0 * * * * *") // Run every minute
    public void sendEventReminders() {
        LocalDateTime now = LocalDateTime.now();
        List<EventsDTO> events = eventsRepository.findByEventTimeBetween(now, now.plusMinutes(10));

        for (EventsDTO event : events) {
            if (event.getNotifyBeforeMinutes() != null && event.getEventTime().minusMinutes(event.getNotifyBeforeMinutes()).isBefore(now)) {
                sendNotification(event);
            }
        }
    }

    private void sendNotification(EventsDTO event) {
        System.out.println("🔔 Event Reminder: " + event.getEventTitle() + " at " + event.getEventTime() + " Location: " + event.getLocation());
        // Implement push/email notifications here
    }

    @Override
    public String calculateETA(String userLocation, String eventLocation) {
        // Mocking an ETA calculation (real-world implementation requires Google Maps API)
        return "Estimated travel time from " + userLocation + " to " + eventLocation + " is 25 minutes.";
    }

    @Override
    public void deleteEvent(Long eventId) {
        eventsRepository.deleteById(eventId);
    }
}
