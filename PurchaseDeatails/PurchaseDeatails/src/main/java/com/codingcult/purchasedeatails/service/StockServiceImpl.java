package com.codingcult.purchasedeatails.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.purchasedeatails.dto.StockDto;
import com.codingcult.purchasedeatails.repo.StockRepository;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public StockDto addStock(StockDto stockDto) {
        return stockRepository.save(stockDto);  // Save stock data to the database
    }

    @Override
    public List<StockDto> getAllStocks() {
        return stockRepository.findAll();  // Get all stocks from the database
    }

    @Override
    public StockDto getStockByItemName(String itemName) {
        return stockRepository.findByItemName(itemName);  // Find stock by item name
    }

    @Override
    public StockDto updateStockQuantity(String itemName, int quantity) {
        StockDto stockDto = stockRepository.findByItemName(itemName);
        if (stockDto != null) {
            stockDto.setQuantity(stockDto.getQuantity() + quantity);  // Update stock quantity
            return stockRepository.save(stockDto);  // Save the updated stock data
        }
        return null;
    }
}
