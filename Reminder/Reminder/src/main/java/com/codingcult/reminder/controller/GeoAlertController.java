package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.GeoAlertDto;
import com.codingcult.reminder.enums.NotificationStatus;
import com.codingcult.reminder.service.GeoAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/geo-alerts")
public class GeoAlertController {

    @Autowired
    private GeoAlertService geoAlertService;

    // Endpoint to create a geo-alert
    @PostMapping("/create")
    public String createGeoAlert(@RequestBody GeoAlertDto geoAlertDto) {
        return geoAlertService.createGeoAlert(geoAlertDto);
    }

    // Endpoint to fetch geo-alerts by phone number
    @GetMapping("/user/{phoneNumber}")
    public List<GeoAlertDto> getUserGeoAlerts(@PathVariable String phoneNumber) {
        return geoAlertService.getUserGeoAlerts(phoneNumber);
    }

    // Endpoint to update the status of a geo-alert
    @PutMapping("/update/{id}")
    public String updateGeoAlertStatus(@PathVariable int id, @RequestParam NotificationStatus status) {
        return geoAlertService.updateGeoAlertStatus(id, status);
    }

    // Endpoint to trigger geo-alert based on location (for testing purposes)
    @PostMapping("/trigger")
    public String triggerGeoAlert(@RequestParam double userLatitude, @RequestParam double userLongitude) {
        geoAlertService.triggerGeoAlert(userLatitude, userLongitude);
        return "Geo-alert trigger check completed.";
    }
}
