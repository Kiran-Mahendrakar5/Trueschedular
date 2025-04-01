package com.codingcult.reminder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.reminder.dto.AlarmDTO;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface AlarmRepository extends JpaRepository<AlarmDTO, Long> {

    List<AlarmDTO> findByUserEmail(String userEmail);
    
    List<AlarmDTO> findByStatusAndEventDate(String status, LocalDateTime eventDate);
}
