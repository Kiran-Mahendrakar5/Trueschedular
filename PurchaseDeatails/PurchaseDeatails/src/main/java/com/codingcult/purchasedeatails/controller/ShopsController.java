package com.codingcult.purchasedeatails.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.purchasedeatails.dto.ShopsDto;
import com.codingcult.purchasedeatails.service.ShopsService;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopsController {

    @Autowired
    private ShopsService shopsService;

    @PostMapping
    public ShopsDto addShopData(@RequestBody ShopsDto shopsDto) {
        return shopsService.addShopData(shopsDto); // Return the saved shop data directly
    }

    @GetMapping
    public List<ShopsDto> getAllShopData() {
        return shopsService.getAllShopData(); // Return all shop data directly
    }
}

