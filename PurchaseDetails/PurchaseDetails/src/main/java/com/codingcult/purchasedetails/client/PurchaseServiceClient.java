package com.codingcult.purchasedetails.client;

import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "purchase-service", url = "http://localhost:9001")
public interface PurchaseServiceClient {

    @GetMapping("/purchase/items/{mobile}")
    List<PurchaseIteamsDto> getItemsByMobile(@PathVariable String mobile);
    
    @GetMapping("/summary/category")
    List<PurchaseIteamsDto> getItemsSummaryByCategory(@RequestParam("mobile") String mobile);
    
    @GetMapping("/purchase/items")
    List<PurchaseIteamsDto> getAllPurchaseItems(); 
}

