package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ActivityLogDto;

import java.util.List;

public interface ActivityLogServiceInterface {

    String logAction(ActivityLogDto logDto);

    List<ActivityLogDto> getAllLogs(String phoneNumber);

    List<ActivityLogDto> getLogsByActionType(String phoneNumber, String actionType);
}
