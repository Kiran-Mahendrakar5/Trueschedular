package com.codingcult.truescheduler.repo;

import com.codingcult.truescheduler.dto.ItemTrackDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemTrackRepo extends JpaRepository<ItemTrackDto, Long> {

}
