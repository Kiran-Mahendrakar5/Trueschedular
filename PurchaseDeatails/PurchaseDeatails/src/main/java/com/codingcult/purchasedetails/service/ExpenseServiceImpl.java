package com.codingcult.purchasedetails.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.purchasedetails.dto.ExpenseDto;
import com.codingcult.purchasedetails.repo.ExpenseRepository;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    @Override
    public ExpenseDto saveExpense(ExpenseDto dto) {
        dto.setActive(true);
        return repository.save(dto);
    }

    @Override
    public List<ExpenseDto> getAllExpensesByUser(String userMobile) {
        return repository.findByUserMobileAndIsActiveTrue(userMobile);
    }

    @Override
    public double getTotalExpenseByUser(String userMobile) {
        return repository.findByUserMobileAndIsActiveTrue(userMobile)
                .stream()
                .mapToDouble(ExpenseDto::getAmount)
                .sum();
    }
}
