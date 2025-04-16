package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.LocationAlertDto;
import com.codingcult.reminder.dto.ReminderDto;
import com.codingcult.reminder.dto.WearableSyncDto;
import com.codingcult.reminder.feign.ReminderServiceClient;
import com.codingcult.reminder.feign.WearableServiceClient;
import com.codingcult.reminder.repo.WearableSyncRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WearableSyncService implements WearableSyncServiceInterface {

    @Autowired
    private WearableSyncRepository wearableSyncRepository;

    @Autowired
    private ReminderService reminderService;

    @Autowired
    private ReminderServiceClient reminderClient;

    @Autowired
    private WearableServiceClient wearableDeviceClient;

    @Override
    public List<ReminderDto> syncReminders(String phoneNumber) {
        return reminderClient.getUserReminders(phoneNumber);
    }

    @Override
    public List<LocationAlertDto> syncLocationAlerts(String phoneNumber) {
        return reminderClient.getUserLocationAlerts(phoneNumber);
    }

    @Override
    public String syncRemindersWithWearable(WearableSyncDto wearableSyncDto) {
        wearableSyncRepository.save(wearableSyncDto);
        return "Reminder synced successfully with wearable device!";
    }

    @Override
    public List<WearableSyncDto> getUserWearableSyncData(String userPhoneNumber) {
        return wearableSyncRepository.findByUserPhoneNumber(userPhoneNumber);
    }

    @Override
    public String removeWearableSyncData(String wearableDeviceId) {
        Optional<WearableSyncDto> syncDataOpt = wearableSyncRepository.findById(wearableDeviceId);
        if (syncDataOpt.isPresent()) {
            wearableSyncRepository.delete(syncDataOpt.get());
            return "Wearable sync data removed successfully!";
        }
        return "Wearable sync data not found!";
    }

    public String syncRemindersToWearableDevices(String phoneNumber) {
        List<ReminderDto> reminders = reminderService.getRemindersByPhoneNumber(phoneNumber);

        if (reminders.isEmpty()) {
            return "No reminders found to sync.";
        }

        String response = wearableDeviceClient.syncWithWearable(reminders);

        if (response.contains("success")) {
            return "Reminders synced successfully with the wearable device!";
        } else {
            return "Failed to sync reminders with the wearable device: " + response;
        }
    }

    @Override
    public List<ReminderDto> getRemindersFromReminderService(String phoneNumber) {
        // Fetch reminders for the given phone number from the reminder service
        return reminderClient.getUserReminders(phoneNumber);
    }

}
