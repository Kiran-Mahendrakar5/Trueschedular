package com.codingcult.purchasedeatails.service;

import com.codingcult.purchasedeatails.dto.PurchaseTimingsDto;
import com.codingcult.purchasedeatails.repo.PurchaseTimingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseTimingsServiceImpl implements PurchaseTimingsService {

    @Autowired
    private PurchaseTimingsRepository purchaseTimingsRepository;

    @Override
    public PurchaseTimingsDto addPurchaseTiming(PurchaseTimingsDto purchaseTiming) {
        return purchaseTimingsRepository.save(purchaseTiming);
    }

    @Override
    public List<PurchaseTimingsDto> getAllPurchaseTimings() {
        return purchaseTimingsRepository.findAll();
    }

    @Override
    public List<PurchaseTimingsDto> getPurchaseTimingsByItem(String item) {
        return purchaseTimingsRepository.findByItem(item);
    }
}
