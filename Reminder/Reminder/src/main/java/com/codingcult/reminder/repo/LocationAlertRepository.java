package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.LocationAlertDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationAlertRepository extends JpaRepository<LocationAlertDto, Integer> {

    // Custom query to fetch location alerts by user's phone number
    List<LocationAlertDto> findByUserPhoneNumber(String userPhoneNumber);
}
