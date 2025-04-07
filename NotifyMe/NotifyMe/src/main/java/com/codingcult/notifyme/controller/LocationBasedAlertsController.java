package com.codingcult.notifyme.controller;

import com.codingcult.notifyme.dto.LocationBasedAlertsDTO;
import com.codingcult.notifyme.service.LocationBasedAlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/location-alerts")
public class LocationBasedAlertsController {

    @Autowired
    private LocationBasedAlertsService locationBasedAlertsService;

    @PostMapping
    public LocationBasedAlertsDTO createLocationAlert(@RequestBody LocationBasedAlertsDTO alert) {
        return locationBasedAlertsService.createLocationAlert(alert);
    }

    @GetMapping
    public List<LocationBasedAlertsDTO> getAllLocationAlerts() {
        return locationBasedAlertsService.getAllLocationAlerts();
    }

    @GetMapping("/{id}")
    public LocationBasedAlertsDTO getLocationAlertById(@PathVariable Long id) {
        Optional<LocationBasedAlertsDTO> alert = locationBasedAlertsService.getLocationAlertById(id);
        return alert.orElse(null);
    }

    @PutMapping("/{id}")
    public LocationBasedAlertsDTO updateLocationAlert(@PathVariable Long id, @RequestBody LocationBasedAlertsDTO updatedAlert) {
        return locationBasedAlertsService.updateLocationAlert(id, updatedAlert);
    }

    @DeleteMapping("/{id}")
    public void deleteLocationAlert(@PathVariable Long id) {
        locationBasedAlertsService.deleteLocationAlert(id);
    }
}