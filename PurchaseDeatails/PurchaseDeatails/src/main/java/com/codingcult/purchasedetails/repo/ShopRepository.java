package com.codingcult.purchasedetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingcult.purchasedetails.dto.ShopDto;

import java.util.List;

public interface ShopRepository extends JpaRepository<ShopDto, Integer> {
    List<ShopDto> findByIsActiveTrue();
    List<ShopDto> findByLocationAndIsActiveTrue(String location);
}
