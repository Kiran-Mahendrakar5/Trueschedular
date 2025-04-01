package com.codingcult.notifyme.repo;

import com.codingcult.notifyme.dto.LocationBasedAlertsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationBasedAlertsRepository extends JpaRepository<LocationBasedAlertsDTO, Long> {
    // Custom query methods can be added here if needed, for example:
    // LocationBasedAlertsDTO findByEventId(Long eventId);
}
