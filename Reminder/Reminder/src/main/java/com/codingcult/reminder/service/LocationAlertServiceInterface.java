package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.LocationAlertDto;
import com.codingcult.reminder.enums.NotificationStatus;

import java.util.List;

public interface LocationAlertServiceInterface {

    String createLocationAlert(LocationAlertDto locationAlertDto);

    List<LocationAlertDto> getUserLocationAlerts(String phoneNumber);

    String updateLocationAlertStatus(int id, NotificationStatus status);

    void triggerLocationAlert(double userLatitude, double userLongitude); // Trigger location-based alerts

	void triggerLocationAlert(String phoneNumber);

	
}
