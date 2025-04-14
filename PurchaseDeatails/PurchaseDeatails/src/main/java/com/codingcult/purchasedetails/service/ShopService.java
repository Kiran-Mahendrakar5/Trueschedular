package com.codingcult.purchasedetails.service;


import java.util.List;

import com.codingcult.purchasedetails.dto.ShopDto;

public interface ShopService {
    ShopDto saveShop(ShopDto shopDto);
    List<ShopDto> getAllShops();
    List<ShopDto> getShopsByLocation(String location);
}
