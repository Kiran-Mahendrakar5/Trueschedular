package com.codingcult.purchasedetails.repo;

import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PurchaseIteamsRepo extends JpaRepository<PurchaseIteamsDto, Integer> {
    List<PurchaseIteamsDto> findByUserMobile(String userMobile);
    
}