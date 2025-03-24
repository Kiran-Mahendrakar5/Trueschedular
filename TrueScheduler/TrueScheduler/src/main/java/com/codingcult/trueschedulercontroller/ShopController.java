package com.codingcult.trueschedulercontroller;

import com.codingcult.truescheduler.dto.ShopDto;
import com.codingcult.truescheduler.service.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/shops")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping
    public ShopDto createShop(@RequestBody ShopDto shopDto) {
        return shopService.saveShop(shopDto);
    }

    @GetMapping
    public List<ShopDto> getAllShops() {
        return shopService.getAllShops();
    }

    @GetMapping("/{id}")
    public ShopDto getShopById(@PathVariable Long id) {
        Optional<ShopDto> shop = shopService.getShopById(id);
        return shop.orElse(null);
    }

    @PutMapping("/{id}")
    public ShopDto updateShop(@PathVariable Long id, @RequestBody ShopDto shopDto) {
        return shopService.updateShop(id, shopDto);
    }

    @DeleteMapping("/{id}")
    public void deleteShop(@PathVariable Long id) {
        shopService.deleteShop(id);
    }
}
