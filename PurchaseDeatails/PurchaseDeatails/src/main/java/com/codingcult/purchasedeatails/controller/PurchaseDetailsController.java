package com.codingcult.purchasedeatails.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.purchasedeatails.dto.PurchaseDetailsDto;
import com.codingcult.purchasedeatails.service.PurchaseDetailsService;

@RestController
@RequestMapping("/api/purchases")
public class PurchaseDetailsController {

    @Autowired
    private PurchaseDetailsService service;

    @PostMapping
    public PurchaseDetailsDto addPurchase(@RequestBody PurchaseDetailsDto purchase) {
        return service.savePurchase(purchase);
    }

    @GetMapping
    public List<PurchaseDetailsDto> getAllPurchases() {
        return service.getAllPurchases();
    }
}
