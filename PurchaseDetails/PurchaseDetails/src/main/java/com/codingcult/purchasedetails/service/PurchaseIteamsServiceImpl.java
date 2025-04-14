
package com.codingcult.purchasedetails.service;

import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.repo.PurchaseIteamsRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class PurchaseIteamsServiceImpl implements PurchaseIteamsService {

    @Autowired
    private PurchaseIteamsRepo purchaseRepo;

    @Override
    public PurchaseIteamsDto saveItem(PurchaseIteamsDto item) {
        if (item.getPurchaseDate() == null || item.getPurchaseDate().isEmpty()) {
            item.setPurchaseDate(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        return purchaseRepo.save(item);
    }
}
