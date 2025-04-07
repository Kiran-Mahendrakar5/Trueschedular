package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.ReminderDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<ReminderDTO, Long> {
    List<ReminderDTO> findByPhoneNumber(String phoneNumber);
    List<ReminderDTO> findByIsActiveTrue();
}
