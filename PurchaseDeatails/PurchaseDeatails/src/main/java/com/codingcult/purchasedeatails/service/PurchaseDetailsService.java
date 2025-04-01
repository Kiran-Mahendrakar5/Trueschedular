package com.codingcult.purchasedeatails.service;

import java.util.List;

import com.codingcult.purchasedeatails.dto.PurchaseDetailsDto;

public interface PurchaseDetailsService {
	public	PurchaseDetailsDto savePurchase(PurchaseDetailsDto purchase);

	public List<PurchaseDetailsDto> getAllPurchases();
}
