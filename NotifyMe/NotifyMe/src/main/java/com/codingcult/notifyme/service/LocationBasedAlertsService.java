package com.codingcult.notifyme.service;

import com.codingcult.notifyme.dto.LocationBasedAlertsDTO;

import java.util.List;
import java.util.Optional;

public interface LocationBasedAlertsService {
    LocationBasedAlertsDTO createLocationAlert(LocationBasedAlertsDTO alert);
    List<LocationBasedAlertsDTO> getAllLocationAlerts();
    Optional<LocationBasedAlertsDTO> getLocationAlertById(Long id);
    LocationBasedAlertsDTO updateLocationAlert(Long id, LocationBasedAlertsDTO updatedAlert);
    void deleteLocationAlert(Long id);
}