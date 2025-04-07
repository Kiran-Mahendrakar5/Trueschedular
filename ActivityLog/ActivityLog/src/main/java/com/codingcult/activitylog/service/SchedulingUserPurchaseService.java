package com.codingcult.activitylog.service;

import java.util.List;
import java.util.Optional;

import com.codingcult.activitylog.dto.Scheduling_UserPurchaseDto;
import com.codingcult.activitylog.repo.SchedulingUserPurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulingUserPurchaseService implements SchedulingUserPurchaseServiceInterface {

    @Autowired
    private SchedulingUserPurchaseRepository repository;

    public Scheduling_UserPurchaseDto savePurchase(Scheduling_UserPurchaseDto purchase) {
        purchase.setActive(true);
        return repository.save(purchase);
    }

    public List<Scheduling_UserPurchaseDto> getAllPurchases() {
        return repository.findByIsActiveTrue(); // Only active
    }

    public Optional<Scheduling_UserPurchaseDto> getPurchaseById(Long id) {
        return repository.findById(id).filter(Scheduling_UserPurchaseDto::isActive); // Only if active
    }

    public Scheduling_UserPurchaseDto updatePurchase(Long id, Scheduling_UserPurchaseDto purchaseDetails) {
        return repository.findById(id).map(purchase -> {
            if (!purchase.isActive()) {
                throw new RuntimeException("Cannot update deleted purchase.");
            }
            purchase.setUserName(purchaseDetails.getUserName());
            purchase.setItem(purchaseDetails.getItem());
            purchase.setAmount(purchaseDetails.getAmount());
            purchase.setLocation(purchaseDetails.getLocation());
            purchase.setPurchaseTime(purchaseDetails.getPurchaseTime());
            return repository.save(purchase);
        }).orElseThrow(() -> new RuntimeException("Purchase not found with ID: " + id));
    }

    // 🔥 Soft delete
    public int deletePurchase(Long id) {
        Optional<Scheduling_UserPurchaseDto> purchaseOpt = repository.findById(id);
        if (purchaseOpt.isPresent() && purchaseOpt.get().isActive()) {
            Scheduling_UserPurchaseDto purchase = purchaseOpt.get();
            purchase.setActive(false);
            repository.save(purchase);
            return 1;
        }
        return 0;
    }
}
