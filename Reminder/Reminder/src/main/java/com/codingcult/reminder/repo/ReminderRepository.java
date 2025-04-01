package com.codingcult.reminder.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.reminder.dto.ReminderDTO;

import java.util.List;

@Repository
public interface ReminderRepository extends JpaRepository<ReminderDTO, Long> {
    
    // Find all reminders for a specific user
    List<ReminderDTO> findByUserEmail(String userEmail);
}
