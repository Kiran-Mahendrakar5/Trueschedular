package com.codingcult.purchasedetails.service;

import com.codingcult.purchasedetails.client.PurchaseServiceClient;
import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.dto.StockMonitorDto;
import com.codingcult.purchasedetails.repo.StockMonitorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StockMonitorServiceImpl implements StockMonitorService {

    @Autowired
    private StockMonitorRepository stockRepo;

    @Autowired
    private PurchaseServiceClient purchaseClient;

    @Override
    public StockMonitorDto saveStockMonitor(StockMonitorDto stockMonitorDto) {
        return stockRepo.save(stockMonitorDto);
    }

    @Override
    public List<StockMonitorDto> getAllStockMonitors() {
        return stockRepo.findByIsActiveTrue();
    }

    @Override
    public StockMonitorDto getStockMonitorBySymbol(String stockSymbol) {
        return stockRepo.findByStockSymbolAndIsActiveTrue(stockSymbol);
    }

    @Override
    public void monitorStockPriceChange() {
        // Logic for monitoring price changes
        // Placeholder for monitoring stock price change logic
    }

    @Override
    public void monitorPurchaseFrequencyAndRecommendRefills() {
        List<PurchaseIteamsDto> allItems = purchaseClient.getAllPurchaseItems();  // Fetch all purchase items

        // Group purchase items by name and count their frequencies
        Map<String, Long> itemPurchaseCount = allItems.stream()
                .collect(Collectors.groupingBy(PurchaseIteamsDto::getItemName, Collectors.counting()));

        // Check each item for stock levels and frequency of purchases
        itemPurchaseCount.forEach((itemName, frequency) -> {
            StockMonitorDto stockMonitor = stockRepo.findByStockSymbolAndIsActiveTrue(itemName);
            if (stockMonitor != null) {
                int quantityLeft = stockMonitor.getQuantityAvailable();
                // Refilling criteria: high frequency and low stock
                if (frequency > 10 && quantityLeft < 20) {  
                    // Log recommendation and enable refill alert
                    System.out.println("Recommendation: Refill stock for " + itemName + " as it has been purchased " + frequency + " times.");
                    stockMonitor.setAlertEnabled(true);  // Enable alert for refill
                    stockRepo.save(stockMonitor);  // Save updated stock monitor
                }
            }
        });
    }

    @Override
    public void processStockRefill() {
        // Logic for processing stock refills
        // Placeholder for stock refill process logic
    }
}
