package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.BillReminderDTO;
import com.codingcult.reminder.service.BillReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/bill-reminders")
public class BillReminderController {

    @Autowired
    private BillReminderService billReminderService;

    @PostMapping
    public BillReminderDTO createBillReminder(@Valid @RequestBody BillReminderDTO billReminderDTO) {
        return billReminderService.createBillReminder(billReminderDTO);
    }



    @GetMapping
    public List<BillReminderDTO> getAllBillReminders() {
        return billReminderService.getAllBillReminders();
    }

    @GetMapping("/{userEmail}")
    public List<BillReminderDTO> getBillRemindersByUserEmail(@PathVariable String userEmail) {
        return billReminderService.getBillRemindersByUserEmail(userEmail);
    }

    @GetMapping("/due-bills")
    public List<BillReminderDTO> getDueBills() {
        return billReminderService.getDueBills();
    }

    @GetMapping("/auto-payment")
    public List<BillReminderDTO> getAutoPaymentBills() {
        return billReminderService.getAutoPaymentBills();
    }

    @DeleteMapping("/{id}")
    public String deleteBillReminder(@PathVariable Long id) {
        billReminderService.deleteBillReminder(id);
        return "Bill reminder deleted successfully!";
    }
}
