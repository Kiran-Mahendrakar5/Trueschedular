package com.codingcult.purchasedetails.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.purchasedetails.dto.ShopDto;
import com.codingcult.purchasedetails.repo.ShopRepository;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopRepository shopRepository;

    @Override
    public ShopDto saveShop(ShopDto shopDto) {
        shopDto.setActive(true);
        return shopRepository.save(shopDto);
    }

    @Override
    public List<ShopDto> getAllShops() {
        return shopRepository.findByIsActiveTrue();
    }

    @Override
    public List<ShopDto> getShopsByLocation(String location) {
        return shopRepository.findByLocationAndIsActiveTrue(location);
    }
}
