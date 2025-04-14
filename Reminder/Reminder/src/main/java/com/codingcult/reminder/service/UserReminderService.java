package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.UserReminderDto;
import java.util.List;

public interface UserReminderService {
    String addUserReminder(UserReminderDto dto);
    List<UserReminderDto> getAllReminders();
}
