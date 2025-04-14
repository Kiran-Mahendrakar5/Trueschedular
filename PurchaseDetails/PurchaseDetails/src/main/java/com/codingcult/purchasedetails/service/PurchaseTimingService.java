package com.codingcult.purchasedetails.service;

import java.util.List;

import com.codingcult.purchasedetails.dto.PurchaseTimingDto;

public interface PurchaseTimingService {
    PurchaseTimingDto saveTiming(PurchaseTimingDto dto);
    List<PurchaseTimingDto> getTimingsByUser(String userMobile);
    PurchaseTimingDto enableAlert(int id, boolean alert);
}