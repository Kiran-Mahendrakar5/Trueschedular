package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ReminderSchedulerDto;
import java.util.List;

public interface ReminderSchedulerService {
    void addSchedule(ReminderSchedulerDto dto);
    List<ReminderSchedulerDto> getAllActiveSchedules();
}
