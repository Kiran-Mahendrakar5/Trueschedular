package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.ReminderDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepository extends JpaRepository<ReminderDto, Integer> {
    List<ReminderDto> findByIsActiveTrue();
    List<ReminderDto> findByCategory(String category);
	List<ReminderDto> findByPhoneNumber(String phoneNumber);
}
