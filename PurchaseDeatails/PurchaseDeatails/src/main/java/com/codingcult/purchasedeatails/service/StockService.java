package com.codingcult.purchasedeatails.service;

import com.codingcult.purchasedeatails.dto.StockDto;
import java.util.List;

public interface StockService {
    StockDto save(StockDto stockDto);
    List<StockDto> getAll();
    StockDto findByItemName(String itemName);
    StockDto updateQuantity(String itemName, int quantity);
    StockDto deactivate(Long id); // For soft delete
}
