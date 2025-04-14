package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ReminderSchedulerDto;
import com.codingcult.reminder.repo.ReminderSchedulerRepository;
import com.codingcult.reminder.service.ReminderSchedulerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReminderSchedulerServiceImpl implements ReminderSchedulerService {

    @Autowired
    private ReminderSchedulerRepository repository;

    @Override
    public void addSchedule(ReminderSchedulerDto dto) {
        repository.save(dto);
    }

    @Override
    public List<ReminderSchedulerDto> getAllActiveSchedules() {
        return repository.findByIsActiveTrue();
    }

    // Scheduled Task to trigger reminders
    @Scheduled(fixedRate = 60000) // Every 1 minute
    public void checkAndTriggerReminders() {
        List<ReminderSchedulerDto> schedules = repository.findByIsActiveTrue();
        LocalDateTime now = LocalDateTime.now().withSecond(0).withNano(0);

        for (ReminderSchedulerDto dto : schedules) {
            if (dto.getScheduleTime().withSecond(0).withNano(0).equals(now)) {
                System.out.println("Trigger Reminder: " + dto.getReminderMessage() + " for " + dto.getUserMobile());

                // Call external Reminder/Recharge services here using RestTemplate or internal logic

                // Optionally disable if not recurring
                if (!dto.isRecurring()) {
                    dto.setActive(false);
                    repository.save(dto);
                }
            }
        }
    }
}
