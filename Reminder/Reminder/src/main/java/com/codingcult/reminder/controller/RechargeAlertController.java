package com.codingcult.reminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.codingcult.reminder.dto.RechargeAlertDTO;
import com.codingcult.reminder.service.RechargeAlertService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/recharge-alerts")
public class RechargeAlertController {

    @Autowired
    private RechargeAlertService rechargeAlertService;

    @PostMapping
    public ResponseEntity<RechargeAlertDTO> createAlert(@Valid @RequestBody RechargeAlertDTO alertDto) {
        RechargeAlertDTO createdAlert = rechargeAlertService.createRechargeAlert(alertDto);
        return new ResponseEntity<>(createdAlert, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RechargeAlertDTO>> getAllAlerts() {
        List<RechargeAlertDTO> alerts = rechargeAlertService.getAllAlerts();
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

    @GetMapping("/{mobileNumber}")
    public ResponseEntity<List<RechargeAlertDTO>> getAlertsByMobile(@PathVariable String mobileNumber) {
        List<RechargeAlertDTO> alerts = rechargeAlertService.getAlertsByMobileNumber(mobileNumber);
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

    @GetMapping("/low-balance")
    public ResponseEntity<List<RechargeAlertDTO>> getLowBalanceAlerts() {
        List<RechargeAlertDTO> alerts = rechargeAlertService.getLowBalanceAlerts();
        return new ResponseEntity<>(alerts, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAlert(@PathVariable Long id) {
        rechargeAlertService.deleteAlert(id);
        return new ResponseEntity<>("Alert deleted successfully!", HttpStatus.OK);
    }
}
