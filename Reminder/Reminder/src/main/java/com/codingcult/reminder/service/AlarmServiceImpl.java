package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.AlarmDTO;
import com.codingcult.reminder.repo.AlarmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    public List<AlarmDTO> getAllAlarmsByUser(String userEmail) {
        return alarmRepository.findByUserEmail(userEmail);
    }

    @Override
    public void updateAlarmStatus(Long alarmId, String newStatus) {
        AlarmDTO alarm = alarmRepository.findById(alarmId).orElseThrow(() -> new RuntimeException("Alarm not found"));
        alarm.setStatus(newStatus);
        alarmRepository.save(alarm);
    }

    @Override
    @Scheduled(cron = "0 0 8 * * *") // Run daily at 8 AM
    public void sendDailySummaryAlerts() {
        LocalDateTime todayStart = LocalDateTime.now().withHour(0).withMinute(0).withSecond(0).withNano(0);
        LocalDateTime todayEnd = todayStart.plusDays(1).minusSeconds(1);

        List<AlarmDTO> alarmsToday = alarmRepository.findByStatusAndEventDate("ACTIVE", todayStart);

        for (AlarmDTO alarm : alarmsToday) {
            sendNotification(alarm); // Send daily notification for each event
        }
    }

    private void sendNotification(AlarmDTO alarmDTO) {
        // Implement logic to send a notification (e.g., via email, push notification)
        System.out.println("Sending notification for event: " + alarmDTO.getEventName());
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
