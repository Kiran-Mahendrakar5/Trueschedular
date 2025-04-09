package com.codingcult.purchasedeatails.controller;

import com.codingcult.purchasedeatails.dto.ExpensesDto;
import com.codingcult.purchasedeatails.service.ExpensesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expenses")
public class ExpensesController {

    @Autowired
    private ExpensesService expensesService;

    @PostMapping
    public ExpensesDto addExpense(@RequestBody ExpensesDto expensesDto) {
        return expensesService.addExpense(expensesDto);
    }

    @GetMapping
    public List<ExpensesDto> getAllExpenses() {
        return expensesService.getAllExpenses();
    }
}
