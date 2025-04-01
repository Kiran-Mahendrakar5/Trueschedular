package com.codingcult.notifyme.service;

import com.codingcult.notifyme.dto.LocationTrackingDto;
import java.util.List;

public interface LocationTrackingService {

    LocationTrackingDto saveLocation(LocationTrackingDto locationTrackingDto);

    List<LocationTrackingDto> getAllLocations();

    LocationTrackingDto getLocationById(Long id);

    LocationTrackingDto updateLocation(Long id, LocationTrackingDto locationTrackingDto);

    void deleteLocation(Long id);
}
