package com.codingcult.purchasedeatails.controller;

import com.codingcult.purchasedeatails.dto.ShopsDto;
import com.codingcult.purchasedeatails.service.ShopsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shops")
public class ShopsController {

    @Autowired
    private ShopsService shopsService;

    @PostMapping
    public ShopsDto addShopData(@RequestBody ShopsDto shopsDto) {
        return shopsService.addShopData(shopsDto);
    }

    @GetMapping
    public List<ShopsDto> getAllShopData() {
        return shopsService.getAllShopData();
    }

    // Soft delete endpoint
    @PutMapping("/deactivate/{id}")
    public ShopsDto deactivateShop(@PathVariable Long id) {
        return shopsService.deactivateShop(id);
    }
}
