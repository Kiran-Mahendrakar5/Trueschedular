package com.codingcult.purchasedeatails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codingcult.purchasedeatails.dto.PurchaseTimingsDto;
import java.util.List;

@Repository
public interface PurchaseTimingsRepository extends JpaRepository<PurchaseTimingsDto, Long> {

    // Custom query to find purchase timings by item name
    List<PurchaseTimingsDto> findByItem(String item);
}
