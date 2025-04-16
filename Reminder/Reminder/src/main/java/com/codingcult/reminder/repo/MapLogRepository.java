package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.MapLogDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MapLogRepository extends JpaRepository<MapLogDto, Integer> {

    List<MapLogDto> findByUserPhoneNumber(String phoneNumber);

    List<MapLogDto> findByUserPhoneNumberAndTimestampBetween(String phoneNumber, LocalDateTime start, LocalDateTime end);
    
    
}
