package com.codingcult.purchasedeatails.service;

import com.codingcult.purchasedeatails.dto.StockDto;
import com.codingcult.purchasedeatails.repo.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    private StockRepository stockRepository;

    @Override
    public StockDto save(StockDto stockDto) {
        return stockRepository.save(stockDto);
    }

    @Override
    public List<StockDto> getAll() {
        return stockRepository.findByIsActiveTrue();
    }

    @Override
    public StockDto findByItemName(String itemName) {
        return stockRepository.findByItemName(itemName);
    }

    @Override
    public StockDto updateQuantity(String itemName, int quantity) {
        StockDto stock = stockRepository.findByItemName(itemName);
        if (stock != null && stock.isActive()) {
            stock.setQuantity(stock.getQuantity() + quantity);
            return stockRepository.save(stock);
        }
        return null;
    }

    @Override
    public StockDto deactivate(Long id) {
        StockDto stock = stockRepository.findById(id).orElse(null);
        if (stock != null) {
            stock.setActive(false);
            return stockRepository.save(stock);
        }
        return null;
    }
}
