package com.codingcult.purchasedeatails.service;



import java.util.List;

import com.codingcult.purchasedeatails.dto.ShopsDto;

public interface ShopsService {

    ShopsDto addShopData(ShopsDto shopsDto); // Add shop data
    List<ShopsDto> getAllShopData();         // Get all shop data
}

