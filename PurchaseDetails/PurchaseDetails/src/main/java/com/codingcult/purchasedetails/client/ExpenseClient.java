package com.codingcult.purchasedetails.client;

import com.codingcult.purchasedetails.dto.ExpenseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "expense-service", url = "${expense.service.url}")
public interface ExpenseClient {

    @PostMapping("/expense/add")
    ExpenseDto addExpense(@RequestBody ExpenseDto dto);

    @GetMapping("/expense/view/{mobile}")
    List<ExpenseDto> viewUserExpenses(@PathVariable("mobile") String userMobile);

    @GetMapping("/expense/total/{mobile}")
    double totalExpense(@PathVariable("mobile") String userMobile);

}
