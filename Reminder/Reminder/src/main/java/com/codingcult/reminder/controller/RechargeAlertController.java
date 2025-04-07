package com.codingcult.reminder.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
    public RechargeAlertDTO createAlert(@Valid @RequestBody RechargeAlertDTO alertDto) {
        return rechargeAlertService.createRechargeAlert(alertDto);
    }

    @GetMapping
    public List<RechargeAlertDTO> getAllAlerts() {
        return rechargeAlertService.getAllAlerts();
    }

    @GetMapping("/{mobileNumber}")
    public List<RechargeAlertDTO> getAlertsByMobile(@PathVariable String mobileNumber) {
        return rechargeAlertService.getAlertsByMobileNumber(mobileNumber);
    }

    @GetMapping("/low-balance")
    public List<RechargeAlertDTO> getLowBalanceAlerts() {
        return rechargeAlertService.getLowBalanceAlerts();
    }

    @DeleteMapping("/{id}")
    public String deleteAlert(@PathVariable Long id) {
        rechargeAlertService.deleteAlert(id);
        return "Alert deleted successfully!";
    }
}
