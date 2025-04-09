package com.codingcult.purchasedeatails.service;

import java.util.List;
import com.codingcult.purchasedeatails.dto.PurchaseDetailsDto;

public interface PurchaseDetailsService {
    PurchaseDetailsDto savePurchase(PurchaseDetailsDto purchase);
    List<PurchaseDetailsDto> getAllPurchases();
}
