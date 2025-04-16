package com.codingcult.reminder.controller;

import com.codingcult.reminder.dto.RechargeAlertDto;
import com.codingcult.reminder.service.RechargeAlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rechargeAlert")
public class RechargeAlertController {

    @Autowired
    private RechargeAlertService rechargeAlertService;
    
    @PostMapping
    public ResponseEntity<String> triggerRechargeAlert(@RequestBody RechargeAlertDto dto) {
        // Your logic here
        System.out.println("Received recharge alert for: " + dto.getMobileNumber());
        return ResponseEntity.ok("Recharge alert triggered.");
    }

    // Endpoint to add a recharge alert
    @PostMapping("/add")
    public String addRechargeAlert(@RequestBody RechargeAlertDto dto) {
        return rechargeAlertService.addRechargeAlert(dto);
    }

    // Endpoint to get all recharge alerts
    @GetMapping("/all")
    public List<RechargeAlertDto> getAllRechargeAlerts() {
        return rechargeAlertService.getAll();
    }

    // Endpoint to get a recharge alert by id
    @GetMapping("/{id}")
    public RechargeAlertDto getRechargeAlertById(@PathVariable int id) {
        return rechargeAlertService.getById(id); // assuming this method is implemented in the service layer
    }
}
