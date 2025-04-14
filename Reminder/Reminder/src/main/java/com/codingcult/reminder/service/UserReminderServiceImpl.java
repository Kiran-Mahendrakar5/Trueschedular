package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.UserReminderDto;
import com.codingcult.reminder.repo.UserReminderRepository;
import com.codingcult.reminder.service.UserReminderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserReminderServiceImpl implements UserReminderService {

    @Autowired
    private UserReminderRepository repository;

    @Override
    public String addUserReminder(UserReminderDto dto) {
        repository.save(dto);
        return "User reminder saved successfully.";
    }

    @Override
    public List<UserReminderDto> getAllReminders() {
        return repository.findByIsActiveTrue();
    }
}
