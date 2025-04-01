package com.codingcult.activitylog.service;

import java.util.List;
import java.util.Optional;

import com.codingcult.activitylog.dto.Scheduling_UserPurchaseDto;

public interface SchedulingUserPurchaseServiceInterface {

	// Create a new purchase
	public Scheduling_UserPurchaseDto savePurchase(Scheduling_UserPurchaseDto purchase);

	// Retrieve all purchases
	public List<Scheduling_UserPurchaseDto> getAllPurchases();

	// Retrieve purchase by ID
	public Optional<Scheduling_UserPurchaseDto> getPurchaseById(Long id);

	// Update purchase
	public Scheduling_UserPurchaseDto updatePurchase(Long id, Scheduling_UserPurchaseDto purchaseDetails);

	// Delete purchase by ID
	public void deletePurchase(Long id);
}
