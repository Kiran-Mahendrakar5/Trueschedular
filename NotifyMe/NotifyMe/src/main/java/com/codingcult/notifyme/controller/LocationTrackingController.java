package com.codingcult.notifyme.controller;

import com.codingcult.notifyme.dto.LocationTrackingDto;
import com.codingcult.notifyme.service.LocationTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationTrackingController {

    @Autowired
    private LocationTrackingService service;

    @PostMapping
    public ResponseEntity<LocationTrackingDto> addLocation(@RequestBody LocationTrackingDto dto) {
        LocationTrackingDto savedLocation = service.saveLocation(dto);
        return ResponseEntity.ok(savedLocation);
    }

    @GetMapping
    public ResponseEntity<List<LocationTrackingDto>> getAllLocations() {
        List<LocationTrackingDto> locations = service.getAllLocations();
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LocationTrackingDto> getLocationById(@PathVariable Long id) {
        LocationTrackingDto location = service.getLocationById(id);
        if (location != null) {
            return ResponseEntity.ok(location);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<LocationTrackingDto> updateLocation(@PathVariable Long id, @RequestBody LocationTrackingDto dto) {
        LocationTrackingDto updatedLocation = service.updateLocation(id, dto);
        if (updatedLocation != null) {
            return ResponseEntity.ok(updatedLocation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLocation(@PathVariable Long id) {
        service.deleteLocation(id);
        return ResponseEntity.ok("Deleted successfully!");
    }
}
