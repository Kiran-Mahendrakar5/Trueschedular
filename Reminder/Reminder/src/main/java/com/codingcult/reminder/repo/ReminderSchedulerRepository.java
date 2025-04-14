package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.ReminderSchedulerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReminderSchedulerRepository extends JpaRepository<ReminderSchedulerDto, Integer> {
    List<ReminderSchedulerDto> findByIsActiveTrue();
}
