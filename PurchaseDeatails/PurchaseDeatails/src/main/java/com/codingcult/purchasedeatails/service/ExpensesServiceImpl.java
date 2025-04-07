package com.codingcult.purchasedeatails.service;

import com.codingcult.purchasedeatails.dto.ExpensesDto;
import com.codingcult.purchasedeatails.repo.ExpensesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Override
    public ExpensesDto addExpense(ExpensesDto expensesDto) {
        expensesDto.setActive(true); // Always set active while saving
        return expensesRepository.save(expensesDto);
    }

    @Override
    public List<ExpensesDto> getAllExpenses() {
        return expensesRepository.findByIsActiveTrue(); // Return only active expenses
    }
}
