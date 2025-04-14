package com.codingcult.purchasedetails.service;


import java.util.List;

import com.codingcult.purchasedetails.dto.ExpenseDto;

public interface ExpenseService {
    ExpenseDto saveExpense(ExpenseDto dto);
    List<ExpenseDto> getAllExpensesByUser(String userMobile);
    double getTotalExpenseByUser(String userMobile);
}
