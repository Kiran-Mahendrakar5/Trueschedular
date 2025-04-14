package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.WearableSyncDto;
import com.codingcult.reminder.service.WearableSyncServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wearable-sync")
public class WearableSyncController {

    @Autowired
    private WearableSyncServiceInterface wearableSyncService;

    // Endpoint to sync reminder with wearable
    @PostMapping("/sync")
    public String syncReminderWithWearable(@RequestBody WearableSyncDto wearableSyncDto) {
        return wearableSyncService.syncRemindersWithWearable(wearableSyncDto);
    }

    // Endpoint to get all reminders synced with wearable devices for a user
    @GetMapping("/user/{userPhoneNumber}")
    public List<WearableSyncDto> getUserWearableSyncData(@PathVariable String userPhoneNumber) {
        return wearableSyncService.getUserWearableSyncData(userPhoneNumber);
    }

    // Endpoint to remove wearable sync data by device ID
    @DeleteMapping("/remove/{wearableDeviceId}")
    public String removeWearableSyncData(@PathVariable String wearableDeviceId) {
        return wearableSyncService.removeWearableSyncData(wearableDeviceId);
    }
}
