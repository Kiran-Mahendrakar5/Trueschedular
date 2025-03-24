package com.codingcult.truescheduler.repo;

import com.codingcult.truescheduler.dto.ShopDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends JpaRepository<ShopDto, Long> {
}
