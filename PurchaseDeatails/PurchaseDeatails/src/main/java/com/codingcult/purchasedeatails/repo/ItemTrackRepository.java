package com.codingcult.purchasedeatails.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.purchasedeatails.dto.ItemTrackDto;


@Repository
public interface ItemTrackRepository extends JpaRepository<ItemTrackDto, Long> {
    ItemTrackDto findByTrackId(String trackId);  // Find item by trackId
}

