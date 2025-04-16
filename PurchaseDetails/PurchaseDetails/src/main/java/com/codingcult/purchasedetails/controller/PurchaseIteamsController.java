package com.codingcult.purchasedetails.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.purchasedetails.client.ShopServiceClient;
import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.dto.ShopDto;
import com.codingcult.purchasedetails.repo.PurchaseIteamsRepo;
import com.codingcult.purchasedetails.service.PurchaseIteamsService;

import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseIteamsController {

    @Autowired
    private PurchaseIteamsService service;

    @Autowired
    private ShopServiceClient shopServiceClient;
    
    @Autowired
    private PurchaseIteamsRepo purchaseRepo;
    
   

    @PostMapping("/{shopId}/addPurchase")
    public String addItem(@PathVariable int shopId, @RequestBody PurchaseIteamsDto item) {
        ShopDto shop = shopServiceClient.getShopById(shopId);
        if (shop == null) return "Shop not found.";

        item.setShop(shop);
        PurchaseIteamsDto saved = service.save(item);
        return "Item saved successfully with ID: " + saved.getId();
    }

    @GetMapping("/items/{mobile}")
    public List<PurchaseIteamsDto> getItemsByMobile(@PathVariable String mobile) {
        return service.getItemsByMobile(mobile);
    }
    
    @GetMapping("/items")
    public List<PurchaseIteamsDto> getAllPurchaseItems() {
        return service.getAllPurchaseItems();
    }
    @GetMapping("/all-items")
    public List<PurchaseIteamsDto> getPurchaseItems() {
        List<PurchaseIteamsDto> purchaseItems = purchaseRepo.findAll();
        for (PurchaseIteamsDto item : purchaseItems) {
            // If shop ID is 0, set custom labels
            if (item.getShop() != null && item.getShop().getId() == 0) {
                item.setStoreName("Invalid Shop");
                item.setLocationTag("Unknown");
            }
        }
        return purchaseItems;
    }

}