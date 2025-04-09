package com.codingcult.purchasedeatails.service;

import com.codingcult.purchasedeatails.dto.ShopsDto;
import java.util.List;

public interface ShopsService {

    ShopsDto addShopData(ShopsDto shopsDto);
    List<ShopsDto> getAllShopData();
    ShopsDto deactivateShop(Long id); // New method to soft delete
}
