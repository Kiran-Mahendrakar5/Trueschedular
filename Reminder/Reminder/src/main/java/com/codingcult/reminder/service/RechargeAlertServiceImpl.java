package com.codingcult.reminder.service;

import java.util.List;
import java.util.Optional;

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
        alertDto.setActive(true); // Ensure active is set
        return rechargeAlertRepository.save(alertDto);
    }

    @Override
    public List<RechargeAlertDTO> getAllAlerts() {
        return rechargeAlertRepository.findByIsActiveTrue();
    }

    @Override
    public List<RechargeAlertDTO> getAlertsByMobileNumber(String mobileNumber) {
        return rechargeAlertRepository.findByMobileNumberAndIsActiveTrue(mobileNumber);
    }

    @Override
    public List<RechargeAlertDTO> getLowBalanceAlerts() {
        return rechargeAlertRepository.findByBalanceLessThanAndIsActiveTrue(50.0); // Example threshold
    }

    @Override
    public void deleteAlert(Long id) {
        Optional<RechargeAlertDTO> optional = rechargeAlertRepository.findById(id);
        if (optional.isPresent()) {
            RechargeAlertDTO alert = optional.get();
            alert.setActive(false); // Soft delete
            rechargeAlertRepository.save(alert);
        }
    }
}
