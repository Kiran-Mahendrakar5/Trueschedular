package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.BillReminderDto;
import com.codingcult.reminder.service.BillReminderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billReminder")
public class BillReminderController {

    @Autowired
    private BillReminderService service;

    @PostMapping("/add")
    public String addReminder(@RequestBody BillReminderDto dto) {
        return service.addBillReminder(dto);
    }

    @GetMapping("/all")
    public List<BillReminderDto> getAll() {
        return service.getAllActiveBills();
    }

    @GetMapping("/type/{type}")
    public List<BillReminderDto> getByType(@PathVariable String type) {
        return service.getBillsByType(type);
    }
}
