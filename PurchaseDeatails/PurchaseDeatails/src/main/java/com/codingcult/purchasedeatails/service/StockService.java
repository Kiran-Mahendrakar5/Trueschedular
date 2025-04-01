package com.codingcult.purchasedeatails.service;



import java.util.List;

import com.codingcult.purchasedeatails.dto.StockDto;

public interface StockService {

    StockDto addStock(StockDto stockDto);  // Add new stock
    List<StockDto> getAllStocks();  // Get all stocks in the inventory
    StockDto getStockByItemName(String itemName);  // Get stock details by item name
    StockDto updateStockQuantity(String itemName, int quantity);  // Update stock quantity
}

