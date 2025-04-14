package com.codingcult.purchasedetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;

@Repository
public interface PurchaseIteamsRepo extends JpaRepository<PurchaseIteamsDto, Integer> {
    // Optional: Add custom queries if needed
}