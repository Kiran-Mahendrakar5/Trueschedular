package com.codingcult.purchasedeatails.service;

import com.codingcult.purchasedeatails.dto.ShopsDto;
import com.codingcult.purchasedeatails.repo.ShopsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopsServiceImpl implements ShopsService {

    @Autowired
    private ShopsRepository shopsRepository;

    @Override
    public ShopsDto addShopData(ShopsDto shopsDto) {
        return shopsRepository.save(shopsDto);
    }

    @Override
    public List<ShopsDto> getAllShopData() {
        return shopsRepository.findByIsActiveTrue();
    }

    @Override
    public ShopsDto deactivateShop(Long id) {
        ShopsDto shop = shopsRepository.findById(id).orElse(null);
        if (shop != null) {
            shop.setActive(false);
            return shopsRepository.save(shop);
        }
        return null;
    }
}
