package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ReminderDTO;
import com.codingcult.reminder.repo.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;

    @Override
    public ReminderDTO createReminder(ReminderDTO reminder) {
        return reminderRepository.save(reminder);
    }

    @Override
    public List<ReminderDTO> getAllReminders() {
        return reminderRepository.findByIsActiveTrue();
    }

    @Override
    public Optional<ReminderDTO> getReminderById(Long id) {
        Optional<ReminderDTO> reminder = reminderRepository.findById(id);
        return reminder.filter(ReminderDTO::isActive);
    }

    @Override
    public List<ReminderDTO> getRemindersByPhone(String phoneNumber) {
        return reminderRepository.findByPhoneNumber(phoneNumber)
                .stream()
                .filter(ReminderDTO::isActive)
                .collect(Collectors.toList());
    }

    @Override
    public ReminderDTO updateReminder(Long id, ReminderDTO updatedReminder) {
        Optional<ReminderDTO> existing = reminderRepository.findById(id);
        if (existing.isPresent() && existing.get().isActive()) {
            updatedReminder.setId(id);
            updatedReminder.setActive(true);
            return reminderRepository.save(updatedReminder);
        }
        return null;
    }

    @Override
    public void deleteReminder(Long id) {
        reminderRepository.findById(id).ifPresent(reminder -> {
            reminder.setActive(false);
            reminderRepository.save(reminder);
        });
    }
}
