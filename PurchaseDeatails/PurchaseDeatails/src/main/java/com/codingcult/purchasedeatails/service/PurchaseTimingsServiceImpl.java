package com.codingcult.purchasedeatails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingcult.purchasedeatails.dto.PurchaseTimingsDto;
import com.codingcult.purchasedeatails.repo.PurchaseTimingsRepository;
import com.codingcult.purchasedeatails.service.PurchaseTimingsService;

import java.util.List;

@Service
public class PurchaseTimingsServiceImpl implements PurchaseTimingsService {

    @Autowired
    private PurchaseTimingsRepository purchaseTimingsRepository;

    @Override
    public PurchaseTimingsDto addPurchaseTiming(PurchaseTimingsDto purchaseTiming) {
        return purchaseTimingsRepository.save(purchaseTiming);  // Save the purchase timing details
    }

    @Override
    public List<PurchaseTimingsDto> getAllPurchaseTimings() {
        return purchaseTimingsRepository.findAll();  // Get all purchase timings from the database
    }

    @Override
    public List<PurchaseTimingsDto> getPurchaseTimingsByItem(String item) {
        return purchaseTimingsRepository.findByItem(item);  // Find purchase timings by item name
    }
}
