package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.DailyScheduleAlarmDto;
import com.codingcult.reminder.repo.DailyScheduleAlarmRepository;
import com.codingcult.reminder.service.DailyScheduleAlarmService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DailyScheduleAlarmServiceImpl implements DailyScheduleAlarmService {

    @Autowired
    private DailyScheduleAlarmRepository repository;

    @Override
    public String addAlarm(DailyScheduleAlarmDto dto) {
        repository.save(dto);
        return "Daily schedule alarm set successfully!";
    }

    @Override
    public List<DailyScheduleAlarmDto> getAllAlarms() {
        return repository.findByIsActiveTrue();
    }
}
