package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.WearableSyncDto;
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

    @Override
    public String syncRemindersWithWearable(WearableSyncDto wearableSyncDto) {
        // Sync reminders/events to wearable device
        wearableSyncRepository.save(wearableSyncDto);
        return "Reminder synced successfully with wearable device!";
    }

    @Override
    public List<WearableSyncDto> getUserWearableSyncData(String userPhoneNumber) {
        // Fetch sync data for the given user phone number
        return wearableSyncRepository.findByUserPhoneNumber(userPhoneNumber);
    }

    @Override
    public String removeWearableSyncData(String wearableDeviceId) {
        // Remove the wearable sync data for the given device
        Optional<WearableSyncDto> syncDataOpt = wearableSyncRepository.findById(wearableDeviceId);
        if (syncDataOpt.isPresent()) {
            wearableSyncRepository.delete(syncDataOpt.get());
            return "Wearable sync data removed successfully!";
        }
        return "Wearable sync data not found!";
    }
}
