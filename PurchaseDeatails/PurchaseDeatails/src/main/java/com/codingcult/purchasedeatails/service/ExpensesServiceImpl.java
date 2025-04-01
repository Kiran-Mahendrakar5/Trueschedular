package com.codingcult.purchasedeatails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.purchasedeatails.dto.ExpensesDto;
import com.codingcult.purchasedeatails.repo.ExpensesRepository;

import java.util.List;

@Service
public class ExpensesServiceImpl implements ExpensesService {

    @Autowired
    private ExpensesRepository expensesRepository;

    @Override
    public ExpensesDto addExpense(ExpensesDto expensesDto) {
        return expensesRepository.save(expensesDto);  // Save the expense to the database
    }

    @Override
    public List<ExpensesDto> getAllExpenses() {
        return expensesRepository.findAll();  // Get all expenses from the database
    }
}
