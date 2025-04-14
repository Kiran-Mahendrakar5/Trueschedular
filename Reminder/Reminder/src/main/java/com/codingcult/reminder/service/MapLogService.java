package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.MapLogDto;
import com.codingcult.reminder.repo.MapLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MapLogService implements MapLogServiceInterface {

    @Autowired
    private MapLogRepository mapLogRepository;

    @Override
    public String logLocation(MapLogDto mapLogDto) {
        mapLogDto.setTimestamp(LocalDateTime.now());
        mapLogRepository.save(mapLogDto);
        return "Location logged successfully.";
    }

    @Override
    public List<MapLogDto> getLocationHistory(String phoneNumber) {
        return mapLogRepository.findByUserPhoneNumber(phoneNumber);
    }

    @Override
    public List<MapLogDto> getLocationHistoryByRange(String phoneNumber, LocalDateTime start, LocalDateTime end) {
        return mapLogRepository.findByUserPhoneNumberAndTimestampBetween(phoneNumber, start, end);
    }
}
