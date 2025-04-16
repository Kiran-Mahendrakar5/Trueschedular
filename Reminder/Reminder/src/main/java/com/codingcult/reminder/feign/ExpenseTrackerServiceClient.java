package com.codingcult.reminder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "expense-tracker-service", url = "http://localhost:9002") // Update URL accordingly
public interface ExpenseTrackerServiceClient {

    @PostMapping("/expense/track")
    void trackExpense(@RequestParam String billType, @RequestParam double amount);

    @PutMapping("/expense/mark-paid/{billId}")
    void markExpenseAsPaid(@PathVariable int billId);
}

