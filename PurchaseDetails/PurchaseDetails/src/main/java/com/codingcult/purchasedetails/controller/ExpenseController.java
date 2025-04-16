package com.codingcult.purchasedetails.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.purchasedetails.dto.ExpenseDto;
import com.codingcult.purchasedetails.service.ExpenseService;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/expense")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/add")
    public ExpenseDto addExpense(@RequestBody ExpenseDto dto) {
        return expenseService.saveExpense(dto);
    }

    @GetMapping("/view/{mobile}")
    public List<ExpenseDto> viewUserExpenses(@PathVariable String mobile) {
        return expenseService.getAllExpensesByUser(mobile);
    }

    @GetMapping("/total/{mobile}")
    public double totalExpense(@PathVariable String mobile) {
        return expenseService.getTotalExpenseByUser(mobile);
    }
    
    @GetMapping("/summary/category/{mobile}")
    public Map<String, Double> getSummaryByCategory(@PathVariable String mobile) {
        return expenseService.getExpenseSummaryByCategory(mobile);
    }

    @GetMapping("/summary/date/{mobile}")
    public Map<LocalDate, Double> getSummaryByDate(@PathVariable String mobile) {
        return expenseService.getExpenseSummaryByDate(mobile);
    }
}