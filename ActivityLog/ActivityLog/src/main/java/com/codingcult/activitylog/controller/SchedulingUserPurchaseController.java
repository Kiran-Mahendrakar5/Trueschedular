package com.codingcult.activitylog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.activitylog.dto.Scheduling_UserPurchaseDto;
import com.codingcult.activitylog.service.SchedulingUserPurchaseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/purchases")
public class SchedulingUserPurchaseController {

    @Autowired
    private SchedulingUserPurchaseService service;

    @PostMapping
    public Scheduling_UserPurchaseDto createPurchase(@RequestBody Scheduling_UserPurchaseDto purchase) {
        return service.savePurchase(purchase);
    }

    @GetMapping
    public List<Scheduling_UserPurchaseDto> getAllPurchases() {
        return service.getAllPurchases();
    }

    @GetMapping("/{id}")
    public Optional<Scheduling_UserPurchaseDto> getPurchaseById(@PathVariable Long id) {
        return service.getPurchaseById(id);
    }

    @PutMapping("/{id}")
    public Scheduling_UserPurchaseDto updatePurchase(@PathVariable Long id,
                                                     @RequestBody Scheduling_UserPurchaseDto purchaseDetails) {
        return service.updatePurchase(id, purchaseDetails);
    }

    @DeleteMapping("/{id}")
    public String deletePurchase(@PathVariable Long id) {
        int result = service.deletePurchase(id);
        if (result == 1) {
            return "Purchase with ID " + id + " deleted (soft delete) successfully.";
        } else {
            return "Purchase with ID " + id + " not found or already deleted.";
        }
    }
}
