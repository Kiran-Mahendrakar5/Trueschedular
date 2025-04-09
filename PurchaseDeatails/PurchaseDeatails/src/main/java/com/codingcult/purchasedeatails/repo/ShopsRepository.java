package com.codingcult.purchasedeatails.repo;

import com.codingcult.purchasedeatails.dto.ShopsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShopsRepository extends JpaRepository<ShopsDto, Long> {
    List<ShopsDto> findByIsActiveTrue(); // Only active shops
}
