package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.BillReminderDto;
import com.codingcult.reminder.service.BillReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billReminder")
public class BillReminderController {

    @Autowired
    private BillReminderService service;

    // Add Bill Reminder
    @PostMapping("/add")
    public ResponseEntity<String> addReminder(@RequestBody BillReminderDto dto) {
        try {
            String response = service.addBillReminder(dto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            // You can log the exception as well
            return new ResponseEntity<>("Error while adding the bill reminder", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get all active bill reminders
    @GetMapping("/all")
    public ResponseEntity<List<BillReminderDto>> getAll() {
        try {
            List<BillReminderDto> reminders = service.getAllActiveBills();
            if (reminders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(reminders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get bill reminders by type (e.g., electricity, rent)
    @GetMapping("/type/{type}")
    public ResponseEntity<List<BillReminderDto>> getByType(@PathVariable String type) {
        try {
            List<BillReminderDto> reminders = service.getBillsByType(type);
            if (reminders.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(reminders, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
