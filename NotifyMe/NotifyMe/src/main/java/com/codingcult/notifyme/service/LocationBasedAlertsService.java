package com.codingcult.notifyme.service;

import com.codingcult.notifyme.dto.LocationBasedAlertsDTO;

import java.util.List;
import java.util.Optional;

public interface LocationBasedAlertsService {

    // Create a new Location-based alert
    LocationBasedAlertsDTO createLocationAlert(LocationBasedAlertsDTO alert);

    // Get all location-based alerts
    List<LocationBasedAlertsDTO> getAllLocationAlerts();

    // Get a location-based alert by its ID
    Optional<LocationBasedAlertsDTO> getLocationAlertById(Long id);

    // Update a location-based alert
    LocationBasedAlertsDTO updateLocationAlert(Long id, LocationBasedAlertsDTO updatedAlert);

    // Delete a location-based alert
    void deleteLocationAlert(Long id);
}

