package com.codingcult.purchasedeatails.service;

import java.util.List;
import com.codingcult.purchasedeatails.dto.ExpensesDto;

public interface ExpensesService {
    ExpensesDto addExpense(ExpensesDto expensesDto);  // Add an expense
    List<ExpensesDto> getAllExpenses();  // Get all expenses
}
