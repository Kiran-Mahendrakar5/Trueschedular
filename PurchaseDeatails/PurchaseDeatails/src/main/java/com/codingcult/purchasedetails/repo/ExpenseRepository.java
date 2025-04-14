package com.codingcult.purchasedetails.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.codingcult.purchasedetails.dto.ExpenseDto;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<ExpenseDto, Integer> {
    List<ExpenseDto> findByUserMobileAndIsActiveTrue(String userMobile);
}
