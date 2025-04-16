package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.LocationAlertDto;
import com.codingcult.reminder.dto.MapLogDto;
import com.codingcult.reminder.dto.PopupNotificationDto;
import com.codingcult.reminder.enums.NotificationStatus;
import com.codingcult.reminder.repo.LocationAlertRepository;
import com.codingcult.reminder.repo.MapLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationAlertService implements LocationAlertServiceInterface {

    @Autowired
    private LocationAlertRepository locationAlertRepository;

    @Autowired
    private MapLogRepository mapLogRepository;

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
    public void triggerLocationAlert(String phoneNumber) {
        List<LocationAlertDto> locationAlerts = locationAlertRepository.findByUserPhoneNumber(phoneNumber);

        for (LocationAlertDto locationAlert : locationAlerts) {
            double distance = calculateDistance(phoneNumber, locationAlert.getLatitude(), locationAlert.getLongitude());
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

    // New method to trigger location alert based on coordinates
    @Override
    public void triggerLocationAlert(double userLatitude, double userLongitude) {
        // Fetch alerts for all users or a specific user
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
        return R * c * 1000; // Convert to meters
    }

    // Overloaded method to calculate distance between user and alert point
    private double calculateDistance(String phoneNumber, double alertLatitude, double alertLongitude) {
        List<MapLogDto> mapLogDtoList = mapLogRepository.findByUserPhoneNumber(phoneNumber);

        if (mapLogDtoList.isEmpty()) {
            return Double.MAX_VALUE; // Return a large distance if no log found
        }

        MapLogDto userLocation = mapLogDtoList.get(0);
        double userLatitude = userLocation.getLatitude();
        double userLongitude = userLocation.getLongitude();

        return calculateDistance(userLatitude, userLongitude, alertLatitude, alertLongitude);
    }
}
