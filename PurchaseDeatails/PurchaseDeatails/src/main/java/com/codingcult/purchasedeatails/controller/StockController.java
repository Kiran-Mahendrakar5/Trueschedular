package com.codingcult.purchasedeatails.controller;

import com.codingcult.purchasedeatails.dto.StockDto;
import com.codingcult.purchasedeatails.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @PostMapping
    public StockDto save(@RequestBody StockDto stockDto) {
        return stockService.save(stockDto);
    }

    @GetMapping
    public List<StockDto> getAll() {
        return stockService.getAll();
    }

    @GetMapping("/{itemName}")
    public StockDto getByItemName(@PathVariable String itemName) {
        return stockService.findByItemName(itemName);
    }

    @PutMapping("/{itemName}/{quantity}")
    public StockDto updateQuantity(@PathVariable String itemName, @PathVariable int quantity) {
        return stockService.updateQuantity(itemName, quantity);
    }

    @PutMapping("/deactivate/{id}")
    public StockDto deactivate(@PathVariable Long id) {
        return stockService.deactivate(id);
    }
}
