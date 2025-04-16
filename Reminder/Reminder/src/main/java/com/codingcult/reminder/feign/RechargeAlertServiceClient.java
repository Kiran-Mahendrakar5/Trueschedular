package com.codingcult.reminder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codingcult.reminder.dto.RechargeAlertDto;

@FeignClient(name = "recharge-alert-service", url = "http://localhost:9002")
public interface RechargeAlertServiceClient {

    @PostMapping("/api/recharge-alerts")
    void triggerRechargeAlert(@RequestBody RechargeAlertDto rechargeAlert);

    // Other methods related to recharge alerts
}