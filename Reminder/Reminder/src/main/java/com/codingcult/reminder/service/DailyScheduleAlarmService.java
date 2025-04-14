package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.DailyScheduleAlarmDto;

import java.util.List;

public interface DailyScheduleAlarmService {
    String addAlarm(DailyScheduleAlarmDto dto);
    List<DailyScheduleAlarmDto> getAllAlarms();
}
