package com.codingcult.notifyme.controller;

import com.codingcult.notifyme.dto.LocationTrackingDto;
import com.codingcult.notifyme.service.LocationTrackingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/locations")
public class LocationTrackingController {

    @Autowired
    private LocationTrackingService service;

    @PostMapping
    public LocationTrackingDto addLocation(@RequestBody LocationTrackingDto dto) {
        return service.saveLocation(dto);
    }

    @GetMapping
    public List<LocationTrackingDto> getAllLocations() {
        return service.getAllLocations();
    }

    @GetMapping("/{id}")
    public LocationTrackingDto getLocationById(@PathVariable Long id) {
        return service.getLocationById(id);
    }

    @PutMapping("/{id}")
    public LocationTrackingDto updateLocation(@PathVariable Long id, @RequestBody LocationTrackingDto dto) {
        return service.updateLocation(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteLocation(@PathVariable Long id) {
        service.deleteLocation(id);
        return "Deleted successfully!";
    }
}
