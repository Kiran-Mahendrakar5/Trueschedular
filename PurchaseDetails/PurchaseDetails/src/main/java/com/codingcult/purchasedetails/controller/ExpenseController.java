package com.codingcult.purchasedetails.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.purchasedetails.dto.ExpenseDto;
import com.codingcult.purchasedetails.service.ExpenseService;

import java.util.List;

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
}