package com.codingcult.purchasedetails.service;

import com.codingcult.purchasedetails.dto.StockMonitorDto;

import java.util.List;

public interface StockMonitorService {
    StockMonitorDto saveStockMonitor(StockMonitorDto stockMonitorDto);
    List<StockMonitorDto> getAllStockMonitors();
    StockMonitorDto getStockMonitorBySymbol(String stockSymbol);
    void monitorStockPriceChange();
}
