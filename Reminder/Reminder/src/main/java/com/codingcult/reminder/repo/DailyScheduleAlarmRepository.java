package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.DailyScheduleAlarmDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DailyScheduleAlarmRepository extends JpaRepository<DailyScheduleAlarmDto, Integer> {
    List<DailyScheduleAlarmDto> findByIsActiveTrue();
}
