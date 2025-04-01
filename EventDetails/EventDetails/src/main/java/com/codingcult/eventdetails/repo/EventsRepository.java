package com.codingcult.eventdetails.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.eventdetails.dto.EventsDTO;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<EventsDTO, Long> {

    List<EventsDTO> findByUserEmail(String userEmail);

    List<EventsDTO> findByEventTimeBetween(LocalDateTime start, LocalDateTime end);
}
