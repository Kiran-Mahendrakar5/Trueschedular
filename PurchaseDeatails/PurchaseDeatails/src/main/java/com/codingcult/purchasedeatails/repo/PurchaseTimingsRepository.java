package com.codingcult.purchasedeatails.repo;

import com.codingcult.purchasedeatails.dto.PurchaseTimingsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchaseTimingsRepository extends JpaRepository<PurchaseTimingsDto, Long> {
    List<PurchaseTimingsDto> findByItem(String item);
}
