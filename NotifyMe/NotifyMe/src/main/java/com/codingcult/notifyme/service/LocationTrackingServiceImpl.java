package com.codingcult.notifyme.service;

import com.codingcult.notifyme.dto.LocationTrackingDto;
import com.codingcult.notifyme.repo.LocationTrackingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationTrackingServiceImpl implements LocationTrackingService {

    @Autowired
    private LocationTrackingRepository repository;

    public LocationTrackingDto saveLocation(LocationTrackingDto dto) {
        return repository.save(dto);
    }

    public List<LocationTrackingDto> getAllLocations() {
        List<LocationTrackingDto> list = repository.findAll();
        list.forEach(dto -> dto.setLocationUrl("https://www.google.com/maps?q=" + dto.getLatitude() + "," + dto.getLongitude()));
        return list;
    }

    public LocationTrackingDto getLocationById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public LocationTrackingDto updateLocation(Long id, LocationTrackingDto dto) {
        if (repository.existsById(id)) {
            dto.setId(id);
            return repository.save(dto);
        }
        return null;
    }

    public void deleteLocation(Long id) {
        repository.deleteById(id);
    }
}
