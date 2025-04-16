package com.codingcult.purchasedetails.service;

import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.dto.ShopDto;
import java.util.List;

public interface ShopService {
    ShopDto saveShop(ShopDto shopDto);
    List<ShopDto> getAllShops();
    List<ShopDto> getShopsByLocation(String location);
    PurchaseIteamsDto addPurchaseToShop(int shopId, PurchaseIteamsDto purchaseItemDto);
    ShopDto findById(int shopId);
}