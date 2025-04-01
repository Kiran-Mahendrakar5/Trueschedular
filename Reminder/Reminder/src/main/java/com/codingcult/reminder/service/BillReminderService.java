package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.BillReminderDTO;
import java.util.List;

public interface BillReminderService {

    BillReminderDTO createBillReminder(BillReminderDTO billReminderDTO);

    List<BillReminderDTO> getAllBillReminders();

    List<BillReminderDTO> getBillRemindersByUserEmail(String userEmail);

    List<BillReminderDTO> getDueBills();

    List<BillReminderDTO> getAutoPaymentBills();

    void deleteBillReminder(Long id);
}
