package com.codingcult.activitylog.service;

import com.codingcult.activitylog.dto.Scheduling_UserPurchaseDto;

import java.util.List;
import java.util.Optional;

public interface SchedulingUserPurchaseServiceInterface {
    Scheduling_UserPurchaseDto savePurchase(Scheduling_UserPurchaseDto dto);
    List<Scheduling_UserPurchaseDto> getAllPurchases();
    Optional<Scheduling_UserPurchaseDto> getPurchaseById(Long id);
    Scheduling_UserPurchaseDto updatePurchase(Long id, Scheduling_UserPurchaseDto dto);
    int deletePurchase(Long id);
}
