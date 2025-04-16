package com.codingcult.purchasedetails.client;

import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.dto.ShopDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "shop-service", url = "http://localhost:9001")
public interface ShopServiceClient {

    @GetMapping("/shop/{shopId}")
    ShopDto getShopById(@PathVariable("shopId") int shopId);

    @PostMapping("/shop/{shopId}/purchase")
    void addPurchaseToShop(@PathVariable("shopId") int shopId, @RequestBody PurchaseIteamsDto purchaseItemDto);
}