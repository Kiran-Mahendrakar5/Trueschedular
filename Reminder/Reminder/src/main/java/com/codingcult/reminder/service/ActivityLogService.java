package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ActivityLogDto;
import com.codingcult.reminder.repo.ActivityLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ActivityLogService implements ActivityLogServiceInterface {

    @Autowired
    private ActivityLogRepository logRepository;

    @Override
    public String logAction(ActivityLogDto logDto) {
        logDto.setTimestamp(LocalDateTime.now());
        logRepository.save(logDto);
        return "Action logged successfully.";
    }

    @Override
    public List<ActivityLogDto> getAllLogs(String phoneNumber) {
        return logRepository.findByUserPhoneNumber(phoneNumber);
    }

    @Override
    public List<ActivityLogDto> getLogsByActionType(String phoneNumber, String actionType) {
        return logRepository.findByUserPhoneNumberAndActionType(phoneNumber, actionType);
    }
}