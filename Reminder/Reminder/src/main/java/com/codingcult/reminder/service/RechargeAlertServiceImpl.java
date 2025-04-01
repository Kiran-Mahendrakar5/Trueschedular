package com.codingcult.reminder.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.reminder.dto.RechargeAlertDTO;
import com.codingcult.reminder.repo.RechargeAlertRepository;

@Service
public class RechargeAlertServiceImpl implements RechargeAlertService {

    @Autowired
    private RechargeAlertRepository rechargeAlertRepository;

    @Override
    public RechargeAlertDTO createRechargeAlert(RechargeAlertDTO alertDto) {
        return rechargeAlertRepository.save(alertDto);
    }

    @Override
    public List<RechargeAlertDTO> getAllAlerts() {
        return rechargeAlertRepository.findAll();
    }

    @Override
    public List<RechargeAlertDTO> getAlertsByMobileNumber(String mobileNumber) {
        return rechargeAlertRepository.findByMobileNumber(mobileNumber);
    }

    @Override
    public List<RechargeAlertDTO> getLowBalanceAlerts() {
        return rechargeAlertRepository.findByBalanceLessThan(50.0); // Example threshold: 50
    }

    @Override
    public void deleteAlert(Long id) {
        rechargeAlertRepository.deleteById(id);
    }
}
