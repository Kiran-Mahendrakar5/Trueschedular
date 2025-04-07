package com.codingcult.purchasedeatails.repo;

import com.codingcult.purchasedeatails.dto.StockDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StockRepository extends JpaRepository<StockDto, Long> {
    StockDto findByItemName(String itemName);
    List<StockDto> findByIsActiveTrue();
}
