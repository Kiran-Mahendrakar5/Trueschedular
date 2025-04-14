package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ReminderDto;

import java.util.List;

public interface ReminderService {
    String saveReminder(ReminderDto dto);
    List<ReminderDto> getAllActiveReminders();
    List<ReminderDto> getRemindersByCategory(String category);
	void sendReminder(String phoneOrEmail, String string);
	
}
