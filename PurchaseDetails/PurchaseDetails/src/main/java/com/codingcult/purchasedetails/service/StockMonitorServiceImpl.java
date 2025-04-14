package com.codingcult.purchasedetails.service;

import com.codingcult.purchasedetails.dto.StockMonitorDto;
import com.codingcult.purchasedetails.repo.StockMonitorRepository;
import com.codingcult.purchasedetails.service.StockMonitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StockMonitorServiceImpl implements StockMonitorService {

    @Autowired
    private StockMonitorRepository stockMonitorRepository;

    @Override
    public StockMonitorDto saveStockMonitor(StockMonitorDto stockMonitorDto) {
        stockMonitorDto.setActive(true);
        return stockMonitorRepository.save(stockMonitorDto);
    }

    @Override
    public List<StockMonitorDto> getAllStockMonitors() {
        return stockMonitorRepository.findByIsActiveTrue();
    }

    @Override
    public StockMonitorDto getStockMonitorBySymbol(String stockSymbol) {
        return stockMonitorRepository.findByStockSymbolAndIsActiveTrue(stockSymbol);
    }

    @Override
    public void monitorStockPriceChange() {
        // Logic to monitor stock prices and trigger alerts
        List<StockMonitorDto> allStocks = getAllStockMonitors();
        for (StockMonitorDto stock : allStocks) {
            // Example: Check if price has fluctuated by more than the alert range
            if (Math.abs(stock.getPrice() - getCurrentPrice(stock.getStockSymbol())) > stock.getAlertRange()) {
                // Trigger alert (e.g., push notification)
                stock.setAlertEnabled(true);
                stockMonitorRepository.save(stock);
            }
        }
    }

    private double getCurrentPrice(String stockSymbol) {
        // Implement a method to fetch the latest price for the stock
        return 100.0; // Placeholder for actual price fetching logic
    }
}