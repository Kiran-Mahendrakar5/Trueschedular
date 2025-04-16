package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.MapLogDto;
import com.codingcult.reminder.repo.MapLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.time.LocalDateTime;
import java.util.Collections;  // for safely returning an empty list

@Service
public class MapLogService implements MapLogServiceInterface {  // Implement the interface

    @Autowired
    private MapLogRepository mapLogRepository;

    @Autowired
    private GeoAlertService geoAlertService;

    @Autowired
    private LocationAlertService locationAlertService;

    @Override  // Implement the methods from MapLogServiceInterface
    public String logLocation(MapLogDto mapLogDto) {
        if (mapLogDto == null || !isValidLocation(mapLogDto)) {
            return "Invalid location data!";
        }

        // Check if the user is inside a geofence (GeoAlertService)
        boolean isInsideGeoFence = geoAlertService.checkGeoFence(mapLogDto.getLatitude(), mapLogDto.getLongitude());

        try {
            // Log the map activity
            mapLogRepository.save(mapLogDto);

            // Trigger an alert if inside the geo-fenced area (LocationAlertService)
            if (isInsideGeoFence) {
                locationAlertService.triggerLocationAlert(mapLogDto.getUserPhoneNumber());
            }

        } catch (Exception e) {
            return "Failed to save location data: " + e.getMessage();
        }

        return "Location logged successfully!";
    }

    @Override  // Implement the methods from MapLogServiceInterface
    public List<MapLogDto> getLocationHistory(String phoneNumber) {
        if (StringUtils.isEmpty(phoneNumber)) {
            return Collections.emptyList(); // Return an empty list safely
        }
        return mapLogRepository.findByUserPhoneNumber(phoneNumber);
    }

    @Override  // Implement the methods from MapLogServiceInterface
    public List<MapLogDto> getLocationHistoryByRange(String phoneNumber, LocalDateTime start, LocalDateTime end) {
        // Add your logic to fetch the location history by date range
        return mapLogRepository.findByUserPhoneNumberAndTimestampBetween(phoneNumber, start, end);
    }

    // Additional helper methods for validation
    private boolean isValidLocation(MapLogDto mapLogDto) {
        if (mapLogDto == null || !StringUtils.hasText(mapLogDto.getUserPhoneNumber())) {
            return false;
        }

        // Latitude and Longitude should be within the valid range
        return isValidCoordinate(mapLogDto.getLatitude()) && isValidCoordinate(mapLogDto.getLongitude());
    }

    private boolean isValidCoordinate(double coordinate) {
        return coordinate >= -90 && coordinate <= 90 && coordinate != 0.0; // Avoiding 0.0 as a default value for invalid coordinates
    }
}
