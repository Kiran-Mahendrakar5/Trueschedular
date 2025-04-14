package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.BillReminderDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillReminderRepository extends JpaRepository<BillReminderDto, Integer> {
    List<BillReminderDto> findByIsActiveTrue();
    List<BillReminderDto> findByBillType(String billType);
}
