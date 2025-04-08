package com.codingcult.eventdetails.repo;

import com.codingcult.eventdetails.dto.EventDetailsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventDetailsRepository extends JpaRepository<EventDetailsDTO, Long> {
    List<EventDetailsDTO> findByPhoneNumberAndIsActiveTrue(String phoneNumber);
    List<EventDetailsDTO> findByIsActiveTrue();
}