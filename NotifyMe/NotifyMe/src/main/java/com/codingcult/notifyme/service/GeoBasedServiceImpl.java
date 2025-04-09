
package com.codingcult.notifyme.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingcult.notifyme.dto.GeoBasedDto;
import com.codingcult.notifyme.repo.GeoBasedRepository;
import java.util.List;

@Service
public class GeoBasedServiceImpl implements GeoBasedService {

    @Autowired
    private GeoBasedRepository geoBasedRepository;

    @Override
    public GeoBasedDto addStore(GeoBasedDto geoBasedDto) {
        return geoBasedRepository.save(geoBasedDto);
    }

    @Override
    public List<GeoBasedDto> getNearbyStores(double latitude, double longitude, double range) {
        double latMin = latitude - range;
        double latMax = latitude + range;
        double lonMin = longitude - range;
        double lonMax = longitude + range;
        return geoBasedRepository.findByLatitudeBetweenAndLongitudeBetween(latMin, latMax, lonMin, lonMax);
    }
}
