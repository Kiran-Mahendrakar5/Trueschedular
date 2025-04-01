package com.codingcult.notifyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codingcult.notifyme.dto.GeoBasedDto;
import java.util.List;

@Repository
public interface GeoBasedRepository extends JpaRepository<GeoBasedDto, Long> {
    
    // Custom query to find stores within a given latitude and longitude range
    List<GeoBasedDto> findByLatitudeBetweenAndLongitudeBetween(double latMin, double latMax, double lonMin, double lonMax);
}

