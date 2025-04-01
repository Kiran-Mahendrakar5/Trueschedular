package com.codingcult.notifyme.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.notifyme.dto.LocationTrackingDto;


@Repository
public interface LocationTrackingRepository extends JpaRepository<LocationTrackingDto, Long> {

}

