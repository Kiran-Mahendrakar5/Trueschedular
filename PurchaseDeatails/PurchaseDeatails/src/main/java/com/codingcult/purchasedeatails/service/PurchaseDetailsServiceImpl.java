package com.codingcult.purchasedeatails.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codingcult.purchasedeatails.dto.PurchaseDetailsDto;
import com.codingcult.purchasedeatails.repo.PurchaseDetailsRepository;

@Service
public class PurchaseDetailsServiceImpl implements PurchaseDetailsService {

    @Autowired
    private PurchaseDetailsRepository repository;

    @Override
    public PurchaseDetailsDto savePurchase(PurchaseDetailsDto purchase) {
        return repository.save(purchase);
    }

    @Override
    public List<PurchaseDetailsDto> getAllPurchases() {
        return repository.findAll();
    }
}
