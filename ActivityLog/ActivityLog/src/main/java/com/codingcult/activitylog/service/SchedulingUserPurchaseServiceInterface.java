package com.codingcult.activitylog.service;

import java.util.List;
import java.util.Optional;

import com.codingcult.activitylog.dto.Scheduling_UserPurchaseDto;

public interface SchedulingUserPurchaseServiceInterface {
    Scheduling_UserPurchaseDto savePurchase(Scheduling_UserPurchaseDto purchase);
    List<Scheduling_UserPurchaseDto> getAllPurchases();
    Optional<Scheduling_UserPurchaseDto> getPurchaseById(Long id);
    Scheduling_UserPurchaseDto updatePurchase(Long id, Scheduling_UserPurchaseDto purchaseDetails);
    int deletePurchase(Long id); // updated return type
}
