package com.codingcult.purchasedetails.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.codingcult.purchasedetails.service.StockMonitorService;

@Component
public class StockMonitorScheduler {

    @Autowired
    private StockMonitorService stockMonitorService;

    // This method will run every day at midnight to check for purchase frequency and recommend refills
    @Scheduled(cron = "0 0 0 * * ?")  // Cron expression to run daily at midnight
    public void schedulePurchaseFrequencyCheck() {
        stockMonitorService.monitorPurchaseFrequencyAndRecommendRefills();
    }
}

