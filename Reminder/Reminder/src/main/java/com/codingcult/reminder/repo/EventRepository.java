package com.codingcult.reminder.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.reminder.dto.EventDto;

@Repository
public interface EventRepository extends JpaRepository<EventDto, Long> {
    // Custom query methods can be added if needed
}
