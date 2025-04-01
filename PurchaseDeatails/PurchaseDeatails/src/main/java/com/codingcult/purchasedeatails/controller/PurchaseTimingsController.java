package com.codingcult.purchasedeatails.controller;



import com.codingcult.purchasedeatails.dto.PurchaseTimingsDto;
import com.codingcult.purchasedeatails.service.PurchaseTimingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/purchase-timings")
public class PurchaseTimingsController {

    @Autowired
    private PurchaseTimingsService purchaseTimingsService;

    // Endpoint to add new purchase timing
    @PostMapping
    public PurchaseTimingsDto addPurchaseTiming(@RequestBody PurchaseTimingsDto purchaseTiming) {
        return purchaseTimingsService.addPurchaseTiming(purchaseTiming);  // Add purchase timing to database
    }

    // Endpoint to get all purchase timings
    @GetMapping
    public List<PurchaseTimingsDto> getAllPurchaseTimings() {
        return purchaseTimingsService.getAllPurchaseTimings();  // Retrieve all purchase timings from database
    }

    // Endpoint to get purchase timings by item name
    @GetMapping("/{item}")
    public List<PurchaseTimingsDto> getPurchaseTimings(@PathVariable String item) {
        return purchaseTimingsService.getPurchaseTimingsByItem(item);  // Retrieve purchase timings for a specific item
    }
}
