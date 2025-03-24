package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.ShopDto;
import java.util.List;
import java.util.Optional;

public interface ShopService {

	public ShopDto saveShop(ShopDto shopDto);

	public List<ShopDto> getAllShops();

	public Optional<ShopDto> getShopById(Long id);

	public ShopDto updateShop(Long id, ShopDto shopDto);

	public void deleteShop(Long id);
}
