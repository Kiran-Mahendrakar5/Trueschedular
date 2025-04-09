package com.codingcult.purchasedeatails.service;

import com.codingcult.purchasedeatails.dto.ExpensesDto;
import java.util.List;

public interface ExpensesService {
    ExpensesDto addExpense(ExpensesDto expensesDto);
    List<ExpensesDto> getAllExpenses();
}
