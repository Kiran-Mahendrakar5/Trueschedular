package com.codingcult.purchasedetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.purchasedetails.dto.PurchaseTimingDto;
import com.codingcult.purchasedetails.repo.PurchaseTimingRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PurchaseTimingServiceImpl implements PurchaseTimingService {

    @Autowired
    private PurchaseTimingRepository repository;

    @Override
    public PurchaseTimingDto saveTiming(PurchaseTimingDto dto) {
        dto.setPurchaseTime(LocalDateTime.now());
        return repository.save(dto);
    }

    @Override
    public List<PurchaseTimingDto> getTimingsByUser(String userMobile) {
        return repository.findByUserMobileAndIsActive(userMobile, true);
    }

    @Override
    public PurchaseTimingDto enableAlert(int id, boolean alert) {
        PurchaseTimingDto dto = repository.findById(id).orElse(null);
        if (dto != null && dto.isActive()) {
            dto.setAlertEnabled(alert);
            return repository.save(dto);
        }
        return null;
    }
}
