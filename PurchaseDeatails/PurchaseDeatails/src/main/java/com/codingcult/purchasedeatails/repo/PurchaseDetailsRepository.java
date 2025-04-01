package com.codingcult.purchasedeatails.repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.codingcult.purchasedeatails.dto.PurchaseDetailsDto;


public interface PurchaseDetailsRepository extends JpaRepository<PurchaseDetailsDto, Long> {
}

