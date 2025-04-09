package com.codingcult.purchasedeatails.repo;

import com.codingcult.purchasedeatails.dto.ItemTrackDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTrackRepository extends JpaRepository<ItemTrackDto, Long> {
    ItemTrackDto findByTrackId(String trackId);
}
