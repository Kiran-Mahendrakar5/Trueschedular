package com.codingcult.purchasedeatails.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.purchasedeatails.dto.StockDto;
import com.codingcult.purchasedeatails.service.StockService;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    // Endpoint to add new stock
    @PostMapping
    public StockDto addStock(@RequestBody StockDto stockDto) {
        return stockService.addStock(stockDto);  // Add new stock item
    }

    // Endpoint to get all stocks
    @GetMapping
    public List<StockDto> getAllStocks() {
        return stockService.getAllStocks();  // Get all stocks in the inventory
    }

    // Endpoint to get stock by item name
    @GetMapping("/{itemName}")
    public StockDto getStock(@PathVariable String itemName) {
        return stockService.getStockByItemName(itemName);  // Get stock details by item name
    }

    // Endpoint to update stock quantity
    @PutMapping("/{itemName}/{quantity}")
    public StockDto updateStock(@PathVariable String itemName, @PathVariable int quantity) {
        return stockService.updateStockQuantity(itemName, quantity);  // Update stock quantity
    }
}

