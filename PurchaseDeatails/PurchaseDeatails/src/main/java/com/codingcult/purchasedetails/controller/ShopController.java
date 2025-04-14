package com.codingcult.purchasedetails.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.purchasedetails.dto.ShopDto;
import com.codingcult.purchasedetails.service.ShopService;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    // Add a new shop
    @PostMapping("/add")
    public ShopDto addShop(@RequestBody ShopDto shopDto) {
        return shopService.saveShop(shopDto);
    }

    // Get all shops
    @GetMapping("/all")
    public List<ShopDto> getAllShops() {
        return shopService.getAllShops();
    }

    // Get shops by location
    @GetMapping("/byLocation/{location}")
    public List<ShopDto> getShopsByLocation(@PathVariable String location) {
        return shopService.getShopsByLocation(location);
    }
}
