package com.codingcult.eventdetails.repo;

import com.codingcult.eventdetails.dto.EventsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventsRepository extends JpaRepository<EventsDTO, Long> {
    List<EventsDTO> findByPhoneNumberAndIsActiveTrue(String phoneNumber);
    List<EventsDTO> findByIsActiveTrue();
}