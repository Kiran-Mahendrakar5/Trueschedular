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

    @PostMapping
    public PurchaseTimingsDto addPurchaseTiming(@RequestBody PurchaseTimingsDto purchaseTiming) {
        return purchaseTimingsService.addPurchaseTiming(purchaseTiming);
    }

    @GetMapping
    public List<PurchaseTimingsDto> getAllPurchaseTimings() {
        return purchaseTimingsService.getAllPurchaseTimings();
    }

    @GetMapping("/{item}")
    public List<PurchaseTimingsDto> getPurchaseTimings(@PathVariable String item) {
        return purchaseTimingsService.getPurchaseTimingsByItem(item);
    }
}
