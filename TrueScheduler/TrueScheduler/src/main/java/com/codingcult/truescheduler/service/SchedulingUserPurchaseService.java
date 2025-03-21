package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.Scheduling_UserPurchaseDto;
import com.codingcult.truescheduler.repo.SchedulingUserPurchaseRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulingUserPurchaseService {

    @Autowired
    private SchedulingUserPurchaseRepository repository;

    // Create a new purchase
    public Scheduling_UserPurchaseDto savePurchase(Scheduling_UserPurchaseDto purchase) {
        return repository.save(purchase);
    }

    // Retrieve all purchases
    public List<Scheduling_UserPurchaseDto> getAllPurchases() {
        return repository.findAll();
    }

    // Retrieve purchase by ID
    public Optional<Scheduling_UserPurchaseDto> getPurchaseById(Long id) {
        return repository.findById(id);
    }

    // Update purchase
    public Scheduling_UserPurchaseDto updatePurchase(Long id, Scheduling_UserPurchaseDto purchaseDetails) {
        return repository.findById(id).map(purchase -> {
            purchase.setUserName(purchaseDetails.getUserName());
            purchase.setItem(purchaseDetails.getItem());
            purchase.setAmount(purchaseDetails.getAmount());
            purchase.setLocation(purchaseDetails.getLocation());
            purchase.setPurchaseTime(purchaseDetails.getPurchaseTime());
            return repository.save(purchase);
        }).orElseThrow(() -> new RuntimeException("Purchase not found with ID: " + id));
    }

    // Delete purchase by ID
    public void deletePurchase(Long id) {
        repository.deleteById(id);
    }
}
