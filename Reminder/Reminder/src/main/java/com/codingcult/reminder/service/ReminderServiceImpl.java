package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.ReminderDto;
import com.codingcult.reminder.repo.ReminderRepository;
import com.codingcult.reminder.service.ReminderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderServiceImpl implements ReminderService {

    @Autowired
    private ReminderRepository repository;

    @Override
    public String saveReminder(ReminderDto dto) {
        repository.save(dto);
        return "Reminder saved successfully.";
    }

    @Override
    public List<ReminderDto> getAllActiveReminders() {
        return repository.findByIsActiveTrue();
    }

    @Override
    public List<ReminderDto> getRemindersByCategory(String category) {
        return repository.findByCategory(category);
    }

    @Override
    public void sendReminder(String phoneOrEmail, String message) {
        // You can implement SMS or Push notification logic here
        // For now, we log the reminder to the console
        System.out.println("Sending reminder to " + phoneOrEmail + ": " + message);
    }
}
