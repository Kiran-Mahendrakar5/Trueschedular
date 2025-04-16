package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ReminderDto;

import java.util.List;

public interface ReminderService {

    // Method to save a reminder
    String saveReminder(ReminderDto dto);

    // Method to get all active reminders
    List<ReminderDto> getAllActiveReminders();

    // Method to get reminders by category
    List<ReminderDto> getRemindersByCategory(String category);

    // Method to send reminder (e.g., push, SMS)
    void sendReminder(String phoneOrEmail, String message);

    // Method to check and send reminders based on their scheduled time
    void checkAndSendReminders();

	List<ReminderDto> getRemindersByPhoneNumber(String phoneNumber);
}
