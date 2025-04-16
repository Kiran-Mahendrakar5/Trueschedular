package com.codingcult.purchasedetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingcult.purchasedetails.client.PurchaseServiceClient;
import com.codingcult.purchasedetails.dto.ExpenseDto;
import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.repo.ExpenseRepository;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ExpenseServiceImpl implements ExpenseService {

    @Autowired
    private ExpenseRepository repository;

    @Autowired
    private PurchaseServiceClient purchaseServiceClient;

    @Override
    public ExpenseDto saveExpense(ExpenseDto dto) {
        dto.setActive(true);
        return repository.save(dto);
    }

    @Override
    public List<ExpenseDto> getAllExpensesByUser(String userMobile) {
        return repository.findByUserMobileAndIsActiveTrue(userMobile);
    }

    @Override
    public double getTotalExpenseByUser(String userMobile) {
        return repository.findByUserMobileAndIsActiveTrue(userMobile)
                .stream()
                .mapToDouble(ExpenseDto::getAmount)
                .sum();
    }

    @Override
    public Map<String, Double> getExpenseSummaryByCategory(String mobile) {
        List<PurchaseIteamsDto> purchases = purchaseServiceClient.getItemsByMobile(mobile);
        if (purchases == null || purchases.isEmpty()) {
            System.out.println("No purchases found for mobile: " + mobile);
            return new HashMap<>();
        }

        // Log the retrieved purchases
        purchases.forEach(purchase -> System.out.println(purchase.toString()));

        return purchases.stream()
                .collect(Collectors.groupingBy(
                        PurchaseIteamsDto::getItemName,
                        Collectors.summingDouble(PurchaseIteamsDto::getPrice)
                ));
    }


    @Override
    public Map<LocalDate, Double> getExpenseSummaryByDate(String mobile) {
        List<PurchaseIteamsDto> purchases = purchaseServiceClient.getItemsByMobile(mobile);
        if (purchases == null || purchases.isEmpty()) return new HashMap<>();

        return purchases.stream()
        		.filter(p -> p.getPurchaseDate() != null && p.getPrice() > 0)


                .collect(Collectors.groupingBy(
                        p -> LocalDate.parse(p.getPurchaseDate()),
                        Collectors.summingDouble(PurchaseIteamsDto::getPrice)
                ));


    }
}
