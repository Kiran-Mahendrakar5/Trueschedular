package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.AlarmDTO;
import com.codingcult.reminder.repo.AlarmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    private AlarmRepository alarmRepository;

    @Override
    public AlarmDTO createAlarm(AlarmDTO alarmDTO) {
        return alarmRepository.save(alarmDTO);
    }

    @Override
    public List<AlarmDTO> getAlarmsByPhoneNumber(String phoneNumber) {
        return alarmRepository.findByPhoneNumberAndIsActiveTrue(phoneNumber);
    }

    @Override
    public void updateAlarmStatus(Long alarmId, String newStatus) {
        AlarmDTO alarm = alarmRepository.findById(alarmId)
                .orElseThrow(() -> new RuntimeException("Alarm not found"));
        alarm.setStatus(newStatus);
        alarmRepository.save(alarm);
    }

    @Override
    public void stopAlarm(Long alarmId) {
        updateAlarmStatus(alarmId, "STOP");
    }

    @Override
    public void pauseAlarm(Long alarmId) {
        updateAlarmStatus(alarmId, "PAUSE");
    }

    @Override
    public void remindLater(Long alarmId) {
        updateAlarmStatus(alarmId, "REMIND LATER");
    }
}
