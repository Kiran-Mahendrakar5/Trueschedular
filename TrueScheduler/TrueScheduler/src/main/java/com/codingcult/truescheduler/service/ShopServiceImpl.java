package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.ShopDto;
import com.codingcult.truescheduler.repo.ShopRepository;
import com.codingcult.truescheduler.service.ShopService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public ShopDto saveShop(ShopDto shopDto) {
        return shopRepository.save(shopDto);
    }

    @Override
    public List<ShopDto> getAllShops() {
        return shopRepository.findAll();
    }

    @Override
    public Optional<ShopDto> getShopById(Long id) {
        return shopRepository.findById(id);
    }

    @Override
    public ShopDto updateShop(Long id, ShopDto shopDto) {
        Optional<ShopDto> existingShop = shopRepository.findById(id);
        if (existingShop.isPresent()) {
            ShopDto shop = existingShop.get();
            shop.setShopName(shopDto.getShopName());
            shop.setLocation(shopDto.getLocation());
            shop.setPurchaseTime(shopDto.getPurchaseTime());
            shop.setPurchasedItem(shopDto.getPurchasedItem());
            shop.setAmountSpent(shopDto.getAmountSpent());
            shop.setPaymentMethod(shopDto.getPaymentMethod());
            return shopRepository.save(shop);
        }
        return null;
    }

    @Override
    public void deleteShop(Long id) {
        shopRepository.deleteById(id);
    }
}
