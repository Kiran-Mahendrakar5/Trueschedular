package com.codingcult.activitylog.controller;

import com.codingcult.activitylog.dto.Scheduling_UserPurchaseDto;
import com.codingcult.activitylog.service.SchedulingUserPurchaseService;
import com.codingcult.eventdetails.dto.EventDetailsDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/activitylog")
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
    public Scheduling_UserPurchaseDto updatePurchase(@PathVariable Long id, @RequestBody Scheduling_UserPurchaseDto purchaseDetails) {
        return service.updatePurchase(id, purchaseDetails);
    }

    @DeleteMapping("/{id}")
    public String deletePurchase(@PathVariable Long id) {
        int result = service.deletePurchase(id);
        return result == 1 ?
                "Purchase with ID " + id + " deleted (soft delete) successfully." :
                "Purchase with ID " + id + " not found or already deleted.";
    }
    
    @GetMapping("/events/phone/{phoneNumber}")
    public List<EventDetailsDTO> getEventsByPhone(@PathVariable String phoneNumber) {
        return service.getEventsByPhoneNumber(phoneNumber);
    }
}
