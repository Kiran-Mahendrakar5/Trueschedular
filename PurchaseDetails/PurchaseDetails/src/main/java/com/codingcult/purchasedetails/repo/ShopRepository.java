package com.codingcult.purchasedetails.repo;

import com.codingcult.purchasedetails.dto.ShopDto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ShopRepository extends JpaRepository<ShopDto, Integer> {
    List<ShopDto> findByIsActiveTrue();
    List<ShopDto> findByLocationAndIsActiveTrue(String location);
}