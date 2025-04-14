package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.LocationAlertDto;
import com.codingcult.reminder.dto.PopupNotificationDto;
import com.codingcult.reminder.enums.NotificationStatus;
import com.codingcult.reminder.repo.LocationAlertRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationAlertService implements LocationAlertServiceInterface {

    @Autowired
    private LocationAlertRepository locationAlertRepository;

    @Autowired
    private PopupNotificationService popupNotificationService;

    @Override
    public String createLocationAlert(LocationAlertDto locationAlertDto) {
        locationAlertDto.setStatus(NotificationStatus.PENDING); // Default status is PENDING
        locationAlertRepository.save(locationAlertDto);
        return "Location alert created successfully!";
    }

    @Override
    public List<LocationAlertDto> getUserLocationAlerts(String phoneNumber) {
        return locationAlertRepository.findByUserPhoneNumber(phoneNumber);
    }

    @Override
    public String updateLocationAlertStatus(int id, NotificationStatus status) {
        Optional<LocationAlertDto> locationAlertOpt = locationAlertRepository.findById(id);
        if (locationAlertOpt.isPresent()) {
            LocationAlertDto locationAlert = locationAlertOpt.get();
            locationAlert.setStatus(status);
            locationAlertRepository.save(locationAlert);
            return "Location alert status updated successfully!";
        } else {
            return "Location alert not found!";
        }
    }

    @Override
    public void triggerLocationAlert(double userLatitude, double userLongitude) {
        List<LocationAlertDto> locationAlerts = locationAlertRepository.findAll();

        for (LocationAlertDto locationAlert : locationAlerts) {
            double distance = calculateDistance(userLatitude, userLongitude, locationAlert.getLatitude(), locationAlert.getLongitude());
            if (distance <= locationAlert.getRadius()) {
                // Send notification via PopupNotificationService
                PopupNotificationDto popupNotification = new PopupNotificationDto();
                popupNotification.setUserPhoneNumber(locationAlert.getUserPhoneNumber());
                popupNotification.setMessage(locationAlert.getMessage());
                popupNotification.setSourceService("LocationAlertService");
                popupNotification.setTriggerTime(locationAlert.getTriggerTime());
                popupNotification.setStatus(NotificationStatus.PENDING);

                popupNotificationService.triggerPopup(popupNotification);
            }
        }
    }

    // Method to calculate the distance between two points (Haversine formula)
    private double calculateDistance(double userLatitude, double userLongitude, double alertLatitude, double alertLongitude) {
        final int R = 6371; // Radius of the earth in km
        double latDistance = Math.toRadians(alertLatitude - userLatitude);
        double lonDistance = Math.toRadians(alertLongitude - userLongitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) +
                Math.cos(Math.toRadians(userLatitude)) * Math.cos(Math.toRadians(alertLatitude)) *
                Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // Convert to meters
        return distance;
    }
}
