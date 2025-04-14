package com.codingcult.purchasedetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.purchasedetails.dto.PurchaseTimingDto;
import com.codingcult.purchasedetails.service.PurchaseTimingService;

import java.util.List;

@RestController
@RequestMapping("/timing")
public class PurchaseTimingController {

    @Autowired
    private PurchaseTimingService service;

    @PostMapping("/add")
    public PurchaseTimingDto addTiming(@RequestBody PurchaseTimingDto dto) {
        return service.saveTiming(dto);
    }

    @GetMapping("/user/{mobile}")
    public List<PurchaseTimingDto> getTimings(@PathVariable String mobile) {
        return service.getTimingsByUser(mobile);
    }

    @PutMapping("/alert/{id}")
    public PurchaseTimingDto updateAlert(@PathVariable int id,
                                         @RequestParam boolean alert) {
        return service.enableAlert(id, alert);
    }
}