package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.BillDto;
import com.codingcult.truescheduler.repo.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;

@Service
public class BillServiceImpl implements BillService {

    @Autowired
    private BillRepository repository;

    @Override
    public BillDto addBill(BillDto bill) {
        return repository.save(bill);
    }

    @Override
    public List<BillDto> getAllBills() {
        return repository.findAll();
    }

    @Override
    public BillDto getBillById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bill not found with ID: " + id));
    }

    @Override
    public BillDto updateBill(Long id, BillDto bill) {
        BillDto existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Bill not found with ID: " + id));

        existing.setBillType(bill.getBillType());
        existing.setAmount(bill.getAmount());
        existing.setDueDate(bill.getDueDate());
        existing.setPaymentMethod(bill.getPaymentMethod());
        existing.setAutoPayment(bill.isAutoPayment());
        existing.setNotified(bill.isNotified());

        return repository.save(existing);
    }

    @Override
    public void deleteBill(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<BillDto> getDueDateNotifications() {
        LocalDate today = LocalDate.now();
        LocalDate notificationDate = today.plusDays(3);  // Notify 3 days before due date
        return repository.findByDueDateBetween(today, notificationDate);
    }

    @Override
    public List<BillDto> getAutoPaymentReminders() {
        return repository.findByAutoPaymentTrue();
    }
}
