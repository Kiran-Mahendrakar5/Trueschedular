package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.ReminderDto;
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

    @PostMapping("/sync")
    public String syncToWearable(@RequestBody ReminderDto dto) {
        System.out.println("Wearable sync received: " + dto);
        return "Synced to wearable successfully";
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
    
 // Endpoint to get reminders by phone number (sync from ReminderService)
 // Add this method in WearableSyncController
    @GetMapping("/reminders/{phoneNumber}")
    public List<ReminderDto> getRemindersByPhoneNumber(@PathVariable String phoneNumber) {
        return wearableSyncService.getRemindersFromReminderService(phoneNumber);
    }

    

}
