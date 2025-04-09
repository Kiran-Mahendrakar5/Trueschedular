package com.codingcult.notifyme.service;

import com.codingcult.notifyme.dto.LocationBasedAlertsDTO;
import com.codingcult.notifyme.repo.LocationBasedAlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationBasedAlertsServiceimpl implements LocationBasedAlertsService {

    @Autowired
    private LocationBasedAlertsRepository locationBasedAlertsRepository;

    public LocationBasedAlertsDTO createLocationAlert(LocationBasedAlertsDTO alert) {
        return locationBasedAlertsRepository.save(alert);
    }

    public List<LocationBasedAlertsDTO> getAllLocationAlerts() {
        return locationBasedAlertsRepository.findAll();
    }

    public Optional<LocationBasedAlertsDTO> getLocationAlertById(Long id) {
        return locationBasedAlertsRepository.findById(id);
    }

    public LocationBasedAlertsDTO updateLocationAlert(Long id, LocationBasedAlertsDTO updatedAlert) {
        if (locationBasedAlertsRepository.existsById(id)) {
            updatedAlert.setId(id);
            return locationBasedAlertsRepository.save(updatedAlert);
        }
        return null;
    }

    public void deleteLocationAlert(Long id) {
        locationBasedAlertsRepository.deleteById(id);
    }
}
