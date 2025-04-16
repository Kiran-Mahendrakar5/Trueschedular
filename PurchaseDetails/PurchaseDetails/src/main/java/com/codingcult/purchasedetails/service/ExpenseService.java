
package com.codingcult.purchasedetails.service;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import com.codingcult.purchasedetails.dto.ExpenseDto;

public interface ExpenseService {
    ExpenseDto saveExpense(ExpenseDto dto);
    List<ExpenseDto> getAllExpensesByUser(String userMobile);
    double getTotalExpenseByUser(String userMobile);
    Map<LocalDate, Double> getExpenseSummaryByDate(String mobile);
    Map<String, Double> getExpenseSummaryByCategory(String mobile);

}

