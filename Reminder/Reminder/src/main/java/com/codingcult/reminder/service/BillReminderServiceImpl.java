package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.BillReminderDTO;
import com.codingcult.reminder.repo.BillReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class BillReminderServiceImpl implements BillReminderService {

    @Autowired
    private BillReminderRepository billReminderRepository;

    @Override
    public BillReminderDTO createBillReminder(BillReminderDTO billReminderDTO) {
        return billReminderRepository.save(billReminderDTO);
    }

    @Override
    public List<BillReminderDTO> getAllBillReminders() {
        return billReminderRepository.findAll();
    }

    @Override
    public List<BillReminderDTO> getBillRemindersByPhoneNumber(String phoneNumber) {
        return billReminderRepository.findByPhoneNumber(phoneNumber);
    }

    @Override
    public List<BillReminderDTO> getDueBills() {
        return billReminderRepository.findByDueDate(LocalDate.now());
    }

    @Override
    public List<BillReminderDTO> getAutoPaymentBills() {
        return billReminderRepository.findByAutoPaymentEnabledTrue();
    }

    @Override
    public void deleteBillReminder(Long id) {
        billReminderRepository.deleteById(id);
    }
}
