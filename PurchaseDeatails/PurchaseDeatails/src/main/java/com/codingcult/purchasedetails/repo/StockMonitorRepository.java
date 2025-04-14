package com.codingcult.purchasedetails.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.codingcult.purchasedetails.dto.StockMonitorDto;

import java.util.List;

public interface StockMonitorRepository extends JpaRepository<StockMonitorDto, Integer> {
    List<StockMonitorDto> findByIsActiveTrue();
    StockMonitorDto findByStockSymbolAndIsActiveTrue(String stockSymbol);
}
