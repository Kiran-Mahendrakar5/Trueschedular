package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.AlarmDTO;

import java.util.List;

public interface AlarmService {
    AlarmDTO createAlarm(AlarmDTO alarmDTO);
    List<AlarmDTO> getAlarmsByPhoneNumber(String phoneNumber);
    void updateAlarmStatus(Long alarmId, String newStatus);
    void stopAlarm(Long alarmId);
    void pauseAlarm(Long alarmId);
    void remindLater(Long alarmId);
}
