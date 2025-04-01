package com.codingcult.purchasedeatails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.purchasedeatails.dto.StockDto;


@Repository
public interface StockRepository extends JpaRepository<StockDto, Long> {
    StockDto findByItemName(String itemName);  // Find stock by item name
}
