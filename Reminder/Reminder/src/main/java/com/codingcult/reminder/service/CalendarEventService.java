package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.CalendarEventDto;
import com.codingcult.reminder.dto.EventDto;
import com.codingcult.reminder.dto.ReminderDto;
import com.codingcult.reminder.feign.EventServiceClient;
import com.codingcult.reminder.feign.ReminderServiceClient;
import com.codingcult.reminder.feign.WearableServiceClient;
import com.codingcult.reminder.repo.CalendarEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarEventService implements CalendarEventServiceInterface {

    @Autowired
    private CalendarEventRepository repo;
    @Autowired
    private EventServiceClient eventClient;

    @Autowired
    private ReminderServiceClient reminderClient;

    @Autowired
    private WearableServiceClient wearableClient;

    @Override
    public String addEvent(CalendarEventDto dto) {
        // Log the event being added
        System.out.println("Adding event: " + dto);

        try {
            // Save the event to the repository
            repo.save(dto);
            System.out.println("Event saved successfully");
        } catch (Exception e) {
            System.out.println("Error saving event: " + e.getMessage());
            e.printStackTrace();
        }

        // Call external services if flags are true
        if (dto.isSendToReminder()) {
            reminderClient.sendReminderFromCalendar(dto);
        }

        if (dto.isSendToWearable()) {
            wearableClient.syncWithWearable(dto);
        }

        // Return success message
        return "Calendar event added and synced if selected.";
    }


    @Override
    public List<CalendarEventDto> getEvents(String phoneNumber) {
        return repo.findByUserPhoneNumber(phoneNumber);
    }
    @Override
    public String createEventAndRemind(EventDto dto) {
        String response = eventClient.createEvent(dto); // ✅

        ReminderDto reminder = new ReminderDto();
        reminder.setPhoneNumber(dto.getUserPhoneNumber()); // ✅
        reminder.setMessage("Upcoming Event: " + dto.getTitle()); // ✅
        reminder.setReminderTime(dto.getStartTime().minusHours(1)); // ✅

        reminderClient.createReminder(reminder);          
        wearableClient.syncToWearable(reminder);          

        return "Event created, reminder sent, and wearable updated.";
    }

}
