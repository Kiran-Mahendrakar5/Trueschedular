package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.MapLogDto;

import java.time.LocalDateTime;
import java.util.List;

public interface MapLogServiceInterface {

    String logLocation(MapLogDto mapLogDto);

    List<MapLogDto> getLocationHistory(String phoneNumber);

    List<MapLogDto> getLocationHistoryByRange(String phoneNumber, LocalDateTime start, LocalDateTime end);
}
