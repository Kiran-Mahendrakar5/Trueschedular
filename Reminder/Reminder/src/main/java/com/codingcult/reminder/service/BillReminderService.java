package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.BillReminderDto;

import java.util.List;

public interface BillReminderService {
    String addBillReminder(BillReminderDto dto);
    List<BillReminderDto> getAllActiveBills();
    List<BillReminderDto> getBillsByType(String type);
}

