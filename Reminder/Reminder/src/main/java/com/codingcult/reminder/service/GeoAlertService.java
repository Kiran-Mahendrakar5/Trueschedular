package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.GeoAlertDto;
import com.codingcult.reminder.dto.PopupNotificationDto;
import com.codingcult.reminder.enums.NotificationStatus;
import com.codingcult.reminder.repo.GeoAlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GeoAlertService implements GeoAlertServiceInterface {

    @Autowired
    private GeoAlertRepository geoAlertRepository;

    @Autowired
    private PopupNotificationService popupNotificationService;

    @Override
    public String createGeoAlert(GeoAlertDto geoAlertDto) {
        geoAlertDto.setStatus(NotificationStatus.PENDING);  // Default status as pending
        geoAlertRepository.save(geoAlertDto);
        return "Geo-alert created successfully!";
    }

    @Override
    public List<GeoAlertDto> getUserGeoAlerts(String phoneNumber) {
        return geoAlertRepository.findByUserPhoneNumber(phoneNumber);
    }

    @Override
    public String updateGeoAlertStatus(int id, NotificationStatus status) {
        Optional<GeoAlertDto> geoAlertOpt = geoAlertRepository.findById(id);
        if (geoAlertOpt.isPresent()) {
            GeoAlertDto geoAlert = geoAlertOpt.get();
            geoAlert.setStatus(status);
            geoAlertRepository.save(geoAlert);
            return "Geo-alert status updated successfully!";
        } else {
            return "Geo-alert not found!";
        }
    }

    public void triggerGeoAlert(double userLatitude, double userLongitude) {
        // Fetch geo-alerts for a specific phone number (replace with the actual phone number or parameter)
        List<GeoAlertDto> geoAlerts = getUserGeoAlerts("9876543210");  // Example phone number

        for (GeoAlertDto geoAlert : geoAlerts) {
            double distance = calculateDistance(userLatitude, userLongitude, geoAlert.getLatitude(), geoAlert.getLongitude());
            if (distance <= geoAlert.getRadius()) {
                // Send the notification to PopupNotificationService
                PopupNotificationDto popupNotification = new PopupNotificationDto();
                popupNotification.setUserPhoneNumber(geoAlert.getUserPhoneNumber());
                popupNotification.setMessage(geoAlert.getMessage());
                popupNotification.setSourceService("GeoBaseService");
                popupNotification.setTriggerTime(geoAlert.getTriggerTime());
                popupNotification.setStatus(NotificationStatus.PENDING);

                popupNotificationService.triggerPopup(popupNotification);
            }
        }
    }

    // Method to calculate the distance between two coordinates (Haversine formula)
    private double calculateDistance(double userLatitude, double userLongitude, double alertLatitude, double alertLongitude) {
        final int R = 6371; // Radius of the Earth in km
        double latDistance = Math.toRadians(alertLatitude - userLatitude);
        double lonDistance = Math.toRadians(alertLongitude - userLongitude);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(userLatitude)) * Math.cos(Math.toRadians(alertLatitude))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c; // in km
        return distance * 1000; // convert to meters
    }
}
