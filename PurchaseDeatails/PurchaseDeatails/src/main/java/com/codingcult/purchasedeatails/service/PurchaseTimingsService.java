package com.codingcult.purchasedeatails.service;

import com.codingcult.purchasedeatails.dto.PurchaseTimingsDto;

import java.util.List;

public interface PurchaseTimingsService {
    PurchaseTimingsDto addPurchaseTiming(PurchaseTimingsDto purchaseTimingsDto);
    List<PurchaseTimingsDto> getAllPurchaseTimings();
    List<PurchaseTimingsDto> getPurchaseTimingsByItem(String item);
}
