package com.codingcult.purchasedeatails.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.purchasedeatails.dto.ShopsDto;

@Repository
public interface ShopsRepository extends JpaRepository<ShopsDto, Long> {

}

