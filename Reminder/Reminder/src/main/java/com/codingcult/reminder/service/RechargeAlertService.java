package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.RechargeAlertDTO;


import java.util.List;

public interface RechargeAlertService {
    
	RechargeAlertDTO createRechargeAlert(RechargeAlertDTO alertDto);
    
    List<RechargeAlertDTO> getAllAlerts();
    
    List<RechargeAlertDTO> getAlertsByMobileNumber(String mobileNumber);
    
    List<RechargeAlertDTO> getLowBalanceAlerts();
    
    void deleteAlert(Long id);
}
