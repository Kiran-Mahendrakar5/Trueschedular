package com.codingcult.reminder.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.reminder.dto.ReminderDTO;
import com.codingcult.reminder.repo.ReminderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    // Create a new reminder
    @Override
    public ReminderDTO createReminder(ReminderDTO reminder) {
        return reminderRepository.save(reminder);
    }

    // Get all reminders
    @Override
    public List<ReminderDTO> getAllReminders() {
        return reminderRepository.findAll();
    }

    // Get a reminder by ID
    @Override
    public Optional<ReminderDTO> getReminderById(Long id) {
        return reminderRepository.findById(id);
    }

    // Get reminders by user email
    @Override
    public List<ReminderDTO> getRemindersByUser(String userEmail) {
        return reminderRepository.findByUserEmail(userEmail);
    }

    // Update a reminder
    @Override
    public ReminderDTO updateReminder(Long id, ReminderDTO updatedReminder) {
        if (reminderRepository.existsById(id)) {
            updatedReminder.setId(id);
            return reminderRepository.save(updatedReminder);
        }
        return null;
    }

    // Delete a reminder
    @Override
    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }
}
