package com.codingcult.purchasedetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codingcult.purchasedetails.dto.PurchaseTimingDto;

import java.util.List;

public interface PurchaseTimingRepository extends JpaRepository<PurchaseTimingDto, Integer> {
    List<PurchaseTimingDto> findByUserMobileAndIsActive(String userMobile, boolean isActive);
}
