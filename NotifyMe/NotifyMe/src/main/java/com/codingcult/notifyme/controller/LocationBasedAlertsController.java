package com.codingcult.notifyme.controller;

import com.codingcult.notifyme.dto.LocationBasedAlertsDTO;
import com.codingcult.notifyme.service.LocationBasedAlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/location-alerts")
public class LocationBasedAlertsController {

    @Autowired
    private LocationBasedAlertsService locationBasedAlertsService;

    // Create a new location-based alert
    @PostMapping
    public ResponseEntity<LocationBasedAlertsDTO> createLocationAlert(@RequestBody LocationBasedAlertsDTO alert) {
        LocationBasedAlertsDTO createdAlert = locationBasedAlertsService.createLocationAlert(alert);
        return new ResponseEntity<>(createdAlert, HttpStatus.CREATED);
    }

    // Get all location-based alerts
    @GetMapping
    public ResponseEntity<List<LocationBasedAlertsDTO>> getAllLocationAlerts() {
        List<LocationBasedAlertsDTO> alerts = locationBasedAlertsService.getAllLocationAlerts();
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

    // Get a location-based alert by ID
    @GetMapping("/{id}")
    public ResponseEntity<LocationBasedAlertsDTO> getLocationAlertById(@PathVariable Long id) {
        Optional<LocationBasedAlertsDTO> alert = locationBasedAlertsService.getLocationAlertById(id);
        if (alert.isPresent()) {
            return new ResponseEntity<>(alert.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Update a location-based alert
    @PutMapping("/{id}")
    public ResponseEntity<LocationBasedAlertsDTO> updateLocationAlert(@PathVariable Long id, @RequestBody LocationBasedAlertsDTO updatedAlert) {
        LocationBasedAlertsDTO alert = locationBasedAlertsService.updateLocationAlert(id, updatedAlert);
        if (alert != null) {
            return new ResponseEntity<>(alert, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a location-based alert
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLocationAlert(@PathVariable Long id) {
        locationBasedAlertsService.deleteLocationAlert(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
