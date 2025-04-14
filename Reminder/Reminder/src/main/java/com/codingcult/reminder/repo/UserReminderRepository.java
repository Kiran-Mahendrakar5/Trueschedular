package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.UserReminderDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReminderRepository extends JpaRepository<UserReminderDto, Integer> {
    List<UserReminderDto> findByIsActiveTrue();
}
