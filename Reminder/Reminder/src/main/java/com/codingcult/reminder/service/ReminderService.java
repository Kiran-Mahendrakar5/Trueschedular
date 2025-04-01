package com.codingcult.reminder.service;


import java.util.List;
import java.util.Optional;

import com.codingcult.reminder.dto.ReminderDTO;

public interface ReminderService {

    // Create a new reminder
    ReminderDTO createReminder(ReminderDTO reminder);

    // Get all reminders
    List<ReminderDTO> getAllReminders();

    // Get a reminder by ID
    Optional<ReminderDTO> getReminderById(Long id);

    // Get reminders by user email
    List<ReminderDTO> getRemindersByUser(String userEmail);

    // Update a reminder
    ReminderDTO updateReminder(Long id, ReminderDTO updatedReminder);

    // Delete a reminder
    void deleteReminder(Long id);
}
