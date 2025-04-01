package com.codingcult.purchasedeatails.service;

import com.codingcult.purchasedeatails.dto.PurchaseTimingsDto;
import java.util.List;

public interface PurchaseTimingsService {

    // Add a new purchase timing
    PurchaseTimingsDto addPurchaseTiming(PurchaseTimingsDto purchaseTimingsDto);

    // Get all purchase timings
    List<PurchaseTimingsDto> getAllPurchaseTimings();

    // Get purchase timings by item
    List<PurchaseTimingsDto> getPurchaseTimingsByItem(String item);
}
