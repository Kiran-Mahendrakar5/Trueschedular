package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ReminderDTO;

import java.util.List;
import java.util.Optional;

public interface ReminderService {
    ReminderDTO createReminder(ReminderDTO reminder);
    List<ReminderDTO> getAllReminders();
    Optional<ReminderDTO> getReminderById(Long id);
    List<ReminderDTO> getRemindersByPhone(String phoneNumber);
    ReminderDTO updateReminder(Long id, ReminderDTO updatedReminder);
    void deleteReminder(Long id); // Soft delete
}
