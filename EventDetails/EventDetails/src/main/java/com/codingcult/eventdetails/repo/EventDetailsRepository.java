package com.codingcult.eventdetails.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.eventdetails.dto.EventDetailsDTO;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventDetailsRepository extends JpaRepository<EventDetailsDTO, Long> {

    List<EventDetailsDTO> findByUserEmail(String userEmail);

    List<EventDetailsDTO> findByNotificationEnabled(Boolean notificationEnabled);

    List<EventDetailsDTO> findByEventStartTimeBetween(LocalDateTime start, LocalDateTime end);
}
