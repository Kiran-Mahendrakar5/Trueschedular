package com.codingcult.purchasedetails.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.purchasedetails.dto.StockMonitorDto;
import com.codingcult.purchasedetails.service.StockMonitorService;

@RestController
@RequestMapping("/stockMonitor") // ✅ Base URL
public class StockMonitorController {

    @Autowired
    private StockMonitorService stockMonitorService;

    @PostMapping("/add") // ✅ This matches your POST URL
    public String addStock(@RequestBody StockMonitorDto dto) {
        stockMonitorService.saveStockMonitor(dto);
        return "Stock Monitor entry added successfully!";
    }



    // Get all stock monitors
    @GetMapping("/all")
    public List<StockMonitorDto> getAllStockMonitors() {
        return stockMonitorService.getAllStockMonitors();
    }

    // Get a specific stock monitor by stock symbol
    @GetMapping("/bySymbol/{stockSymbol}")
    public StockMonitorDto getStockMonitorBySymbol(@PathVariable String stockSymbol) {
        return stockMonitorService.getStockMonitorBySymbol(stockSymbol);
    }

    // Monitor stock prices and trigger alerts
    @PostMapping("/monitor")
    public void monitorStockPriceChange() {
        stockMonitorService.monitorStockPriceChange();
    }
}
