
package com.codingcult.purchasedetails.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.purchasedetails.dto.ItemTrackDto;

import java.util.List;

@Repository
public interface ItemTrackRepo extends JpaRepository<ItemTrackDto, Integer> {
    List<ItemTrackDto> findByUserMobile(String userMobile);
}
