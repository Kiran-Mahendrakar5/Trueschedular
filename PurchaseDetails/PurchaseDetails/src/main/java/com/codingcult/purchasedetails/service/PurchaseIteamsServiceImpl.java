package com.codingcult.purchasedetails.service;

import com.codingcult.purchasedetails.client.ShopServiceClient;
import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.dto.ShopDto;
import com.codingcult.purchasedetails.repo.PurchaseIteamsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class PurchaseIteamsServiceImpl implements PurchaseIteamsService {

    @Autowired
    private PurchaseIteamsRepo purchaseRepo;

    @Autowired
    private ShopServiceClient shopServiceClient;
    
   
	

    @Override
    public PurchaseIteamsDto save(PurchaseIteamsDto dto) {
        if (dto.getShop() != null && dto.getShop().getId() > 0) {
            try {
                ShopDto shop = shopServiceClient.getShopById(dto.getShop().getId());
                if (shop != null && shop.isActive()) {
                    dto.setStoreName(shop.getShopName());
                    dto.setLocationTag(shop.getLocation());
                } else {
                    dto.setStoreName("Invalid Shop");
                    dto.setLocationTag("Unknown");
                }
            } catch (Exception e) {
                dto.setStoreName("Unavailable");
                dto.setLocationTag("Not Fetched");
            }
        } else {
            dto.setStoreName("Invalid Shop");
            dto.setLocationTag("Unknown");
        }

        if (dto.getPurchaseDate() == null || dto.getPurchaseDate().trim().isEmpty()) {
            dto.setPurchaseDate(LocalDate.now().toString());
        }

        return purchaseRepo.save(dto);
    }


    @Override
    public List<PurchaseIteamsDto> getItemsByMobile(String mobile) {
        return purchaseRepo.findByUserMobile(mobile);
    }
    @Override
    public List<PurchaseIteamsDto> getAllItems() {
        return purchaseRepo.findAll();
    }

    @Override
    public List<PurchaseIteamsDto> getAllPurchaseItems() {
        return purchaseRepo.findAll();
    }

}
