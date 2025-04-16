package com.codingcult.purchasedetails.controller;

import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.dto.ShopDto;
import com.codingcult.purchasedetails.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/add")
    public ShopDto addShop(@RequestBody ShopDto shopDto) {
        return shopService.saveShop(shopDto);
    }

    @PostMapping("/{shopId}/purchase")
    public ResponseEntity<String> addPurchaseToShop(@PathVariable int shopId, @RequestBody PurchaseIteamsDto purchaseItemDto) {
        shopService.addPurchaseToShop(shopId, purchaseItemDto);
        return ResponseEntity.ok("Purchase added successfully to the shop with ID " + shopId);
    }

    @GetMapping("/all")
    public List<ShopDto> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/{shopId}")
    public ShopDto getShopById(@PathVariable("shopId") int shopId) {
        return shopService.findById(shopId);
    }
}
