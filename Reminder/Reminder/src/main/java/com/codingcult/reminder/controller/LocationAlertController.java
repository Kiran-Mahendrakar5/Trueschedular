package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.LocationAlertDto;
import com.codingcult.reminder.dto.ReminderDto;
import com.codingcult.reminder.enums.NotificationStatus;
import com.codingcult.reminder.feign.ReminderServiceClient;
import com.codingcult.reminder.service.LocationAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/location-alerts")
public class LocationAlertController {

    @Autowired
    private LocationAlertService locationAlertService;
    
    @Autowired
    private ReminderServiceClient reminderClient;

    @PostMapping("/trigger-and-remind")
    public String triggerLocationAlertAndRemind(@RequestBody LocationAlertDto request) {
        // Print the location details for debugging
        System.out.println("User Latitude: " + request.getLatitude());
        System.out.println("User Longitude: " + request.getLongitude());

        // Trigger location alert logic
        locationAlertService.triggerLocationAlert(request.getLatitude(), request.getLongitude());

        // Set the reminder details
        ReminderDto reminderDto = new ReminderDto();
        reminderDto.setTitle(request.getMessage());  // Set title from alert message
        reminderDto.setCategory("User");
        reminderDto.setReminderTime(request.getTriggerTime());
        reminderDto.setRecurring(false);
        reminderDto.setRepeatCycle("");  // No repeat cycle in this case
        reminderDto.setActive(true);

        // Call the reminder service to trigger reminder
        reminderClient.triggerReminder(reminderDto);

        return "Location alert checked and reminder triggered.";
    }

    // Endpoint to create a location-based alert
    @PostMapping("/create")
    public String createLocationAlert(@RequestBody LocationAlertDto locationAlertDto) {
        return locationAlertService.createLocationAlert(locationAlertDto);
    }

    // Endpoint to fetch all location-based alerts for a user
    @GetMapping("/user/{phoneNumber}")
    public List<LocationAlertDto> getUserLocationAlerts(@PathVariable String phoneNumber) {
        return locationAlertService.getUserLocationAlerts(phoneNumber);
    }

    // Endpoint to update the status of a location-based alert
    @PutMapping("/update/{id}")
    public String updateLocationAlertStatus(@PathVariable int id, @RequestParam NotificationStatus status) {
        return locationAlertService.updateLocationAlertStatus(id, status);
    }

    // Endpoint to trigger location-based alerts
    @PostMapping("/trigger")
    public ResponseEntity<String> triggerLocationAlert(@RequestParam double userLatitude, @RequestParam double userLongitude) {
        if (userLatitude < -90 || userLatitude > 90 || userLongitude < -180 || userLongitude > 180) {
            return ResponseEntity.badRequest().body("Invalid coordinates!");
        }
        locationAlertService.triggerLocationAlert(userLatitude, userLongitude);
        return ResponseEntity.ok("Location alert trigger check completed.");
    }
}
