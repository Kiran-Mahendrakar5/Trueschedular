package com.codingcult.reminder.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.codingcult.reminder.dto.BillReminderDTO;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BillReminderRepository extends JpaRepository<BillReminderDTO, Long> {
    
    List<BillReminderDTO> findByUserEmail(String userEmail);

    List<BillReminderDTO> findByDueDate(LocalDate dueDate);

    List<BillReminderDTO> findByAutoPaymentEnabledTrue();
}
