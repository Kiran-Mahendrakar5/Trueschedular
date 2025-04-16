package com.codingcult.purchasedetails.controller;

import com.codingcult.purchasedetails.dto.StockMonitorDto;
import com.codingcult.purchasedetails.service.StockMonitorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stockMonitor")
public class StockMonitorController {

    @Autowired
    private StockMonitorService stockMonitorService;

    // Endpoint to add a new stock monitor
    @PostMapping("/add")
    public String addStock(@RequestBody StockMonitorDto dto) {
        stockMonitorService.saveStockMonitor(dto);
        return "Stock Monitor entry added successfully!";
    }

    // Endpoint to get all stock monitors
    @GetMapping("/all")
    public List<StockMonitorDto> getAllStockMonitors() {
        return stockMonitorService.getAllStockMonitors();
    }

    // Endpoint to get a specific stock monitor by stock symbol
    @GetMapping("/bySymbol/{stockSymbol}")
    public StockMonitorDto getStockMonitorBySymbol(@PathVariable String stockSymbol) {
        return stockMonitorService.getStockMonitorBySymbol(stockSymbol);
    }

    // Endpoint to monitor stock price changes
    @PostMapping("/monitor")
    public ResponseEntity<String> monitorStockPriceChange() {
        stockMonitorService.monitorStockPriceChange();
        return ResponseEntity.ok("Stock price monitoring completed and alerts triggered if necessary.");
    }

    // Endpoint to monitor purchase frequency and recommend stock refills
    @PostMapping("/monitor/purchaseFrequency")
    public String monitorPurchaseFrequency() {
        stockMonitorService.monitorPurchaseFrequencyAndRecommendRefills();
        return "Purchase frequency monitoring triggered successfully.";
    }

    // Endpoint to trigger stock refill process
    @PostMapping("/process/refill")
    public String processStockRefill() {
        stockMonitorService.processStockRefill();
        return "Stock refill process initiated.";
    }
}
