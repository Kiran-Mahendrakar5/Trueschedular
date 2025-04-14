package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.LocationAlertDto;
import com.codingcult.reminder.enums.NotificationStatus;
import com.codingcult.reminder.service.LocationAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/location-alerts")
public class LocationAlertController {

    @Autowired
    private LocationAlertService locationAlertService;

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
    public String triggerLocationAlert(@RequestParam double userLatitude, @RequestParam double userLongitude) {
        locationAlertService.triggerLocationAlert(userLatitude, userLongitude);
        return "Location alert trigger check completed.";
    }
}
