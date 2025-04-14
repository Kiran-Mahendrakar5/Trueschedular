package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.CalendarEventDto;
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
}
