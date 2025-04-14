package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.GeoAlertDto;
import com.codingcult.reminder.enums.NotificationStatus;

import java.util.List;

public interface GeoAlertServiceInterface {

    String createGeoAlert(GeoAlertDto geoAlertDto);

    List<GeoAlertDto> getUserGeoAlerts(String phoneNumber);

    String updateGeoAlertStatus(int id, NotificationStatus status);
}
