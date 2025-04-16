package com.codingcult.purchasedetails.service;

import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.dto.ShopDto;
import com.codingcult.purchasedetails.repo.ShopRepository;
import com.codingcult.purchasedetails.repo.PurchaseIteamsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepo;

    @Autowired
    private PurchaseIteamsRepo purchaseRepo;

    @Override
    public ShopDto saveShop(ShopDto shopDto) {
        return shopRepo.save(shopDto);
    }

    @Override
    public List<ShopDto> getAllShops() {
        return shopRepo.findAll();
    }

    @Override
    public List<ShopDto> getShopsByLocation(String location) {
        return shopRepo.findByLocationAndIsActiveTrue(location);
    }

    @Override
    public PurchaseIteamsDto addPurchaseToShop(int shopId, PurchaseIteamsDto purchaseItemDto) {
        ShopDto shop = findById(shopId);
        purchaseItemDto.setShop(shop);
        purchaseItemDto.setStoreName(shop.getShopName());
        return purchaseRepo.save(purchaseItemDto);
    }

    @Override
    public ShopDto findById(int shopId) {
        return shopRepo.findById(shopId).orElse(null);
    }
}
