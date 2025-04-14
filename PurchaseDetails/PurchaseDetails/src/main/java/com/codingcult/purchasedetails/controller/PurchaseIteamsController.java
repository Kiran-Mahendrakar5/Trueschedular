package com.codingcult.purchasedetails.controller;

import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.service.PurchaseIteamsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/purchase")
public class PurchaseIteamsController {

    @Autowired
    private PurchaseIteamsService service;

    @PostMapping("/add")
    public String addItem(@RequestBody PurchaseIteamsDto item) {
        PurchaseIteamsDto saved = service.saveItem(item);
        return "Item saved successfully with ID: " + saved.getId();
    }

}