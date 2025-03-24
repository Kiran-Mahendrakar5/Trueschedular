package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.RechargeDto;
import com.codingcult.truescheduler.repo.RechargeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RechargeServiceImpl implements RechargeService {

    @Autowired
    private RechargeRepository repository;

    @Override
    public RechargeDto saveRecharge(RechargeDto dto) {
        return repository.save(dto);
    }

    @Override
    public RechargeDto getRechargeById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Recharge not found with ID: " + id));
    }

    @Override
    public List<RechargeDto> getAllRecharges() {
        return repository.findAll();
    }

    @Override
    public List<RechargeDto> getRechargesByMobile(String mobileNumber) {
        return repository.findByMobileNumber(mobileNumber);
    }

    @Override
    public void deleteRecharge(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Recharge not found with ID: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<RechargeDto> suggestBestPlans(String mobileNumber) {
        List<RechargeDto> plans = repository.findByMobileNumber(mobileNumber);
        return plans.stream()
                .filter(p -> p.getBalance() < 50)
                .sorted((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean isLowBalance(String mobileNumber, double threshold) {
        List<RechargeDto> plans = repository.findByMobileNumber(mobileNumber);
        return plans.stream().anyMatch(p -> p.getBalance() < threshold);
    }
}
