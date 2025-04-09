package com.codingcult.notifyme.service;

import com.codingcult.notifyme.dto.GeoBasedDto;
import java.util.List;

public interface GeoBasedService {
    GeoBasedDto addStore(GeoBasedDto geoBasedDto);  // Add a store
    List<GeoBasedDto> getNearbyStores(double latitude, double longitude, double range);  // Find nearby stores
}
