package com.codingcult.purchasedetails.service;

import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import java.util.List;

public interface PurchaseIteamsService {
    PurchaseIteamsDto save(PurchaseIteamsDto dto);
    List<PurchaseIteamsDto> getItemsByMobile(String mobile);
    public List<PurchaseIteamsDto> getAllItems();
	List<PurchaseIteamsDto> getAllPurchaseItems();
	
}