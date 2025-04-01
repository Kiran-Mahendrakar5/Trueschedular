package com.codingcult.purchasedeatails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.purchasedeatails.dto.ExpensesDto;
import com.codingcult.purchasedeatails.service.ExpensesService;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    // Add an expense record
    @PostMapping
    public ExpensesDto addExpense(@RequestBody ExpensesDto expensesDto) {
        return expensesService.addExpense(expensesDto);
    }

    // Get all expense records
    @GetMapping
    public List<ExpensesDto> getAllExpenses() {
        return expensesService.getAllExpenses();
    }
}
