package com.codingcult.notifyme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.notifyme.dto.GeoBasedDto;
import com.codingcult.notifyme.service.GeoBasedService;

import java.util.List;

@RestController
@RequestMapping("/api/geo")
public class GeoBasedController {

    @Autowired
    private GeoBasedService geoBasedService;

    // Add a new store
    @PostMapping("/add")
    public GeoBasedDto addStore(@RequestBody GeoBasedDto geoBasedDto) {
        return geoBasedService.addStore(geoBasedDto);
    }

    // Get nearby stores within a specified range
    @GetMapping("/nearby")
    public List<GeoBasedDto> getNearbyStores(@RequestParam double latitude, @RequestParam double longitude, @RequestParam double range) {
        return geoBasedService.getNearbyStores(latitude, longitude, range);
    }
}
