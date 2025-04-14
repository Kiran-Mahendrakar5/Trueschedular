package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.RechargeAlertDto;

import java.util.List;

public interface RechargeAlertService {
    String addRechargeAlert(RechargeAlertDto dto);
    List<RechargeAlertDto> getAll();
    void checkAndSendRechargeAlerts();
    public RechargeAlertDto getById(int id);
  

}
