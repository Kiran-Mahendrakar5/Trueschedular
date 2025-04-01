package com.codingcult.purchasedeatails.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.purchasedeatails.dto.ShopsDto;
import com.codingcult.purchasedeatails.repo.ShopsRepository;

import java.util.List;

@Service
public class ShopsServiceImpl implements ShopsService {

    @Autowired
    private ShopsRepository shopsRepository;

    @Override
    public ShopsDto addShopData(ShopsDto shopsDto) {
        return shopsRepository.save(shopsDto); // Save shop data to the database
    }

    @Override
    public List<ShopsDto> getAllShopData() {
        return shopsRepository.findAll(); // Get all shop data from the database
    }
}

