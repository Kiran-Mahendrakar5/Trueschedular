package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.BillReminderDto;
import com.codingcult.reminder.repo.BillReminderRepository;
import com.codingcult.reminder.service.BillReminderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillReminderServiceImpl implements BillReminderService {

    @Autowired
    private BillReminderRepository repository;

    @Override
    public String addBillReminder(BillReminderDto dto) {
        repository.save(dto);
        return "Bill reminder saved successfully.";
    }

    @Override
    public List<BillReminderDto> getAllActiveBills() {
        return repository.findByIsActiveTrue();
    }

    @Override
    public List<BillReminderDto> getBillsByType(String type) {
        return repository.findByBillType(type);
    }
}
