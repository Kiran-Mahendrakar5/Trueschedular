package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.GeoAlertDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeoAlertRepository extends JpaRepository<GeoAlertDto, Integer> {

    // Custom query to fetch geo alerts by user phone number
    List<GeoAlertDto> findByUserPhoneNumber(String phoneNumber);
}
