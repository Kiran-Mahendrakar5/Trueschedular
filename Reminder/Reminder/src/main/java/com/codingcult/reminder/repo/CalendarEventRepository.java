package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.CalendarEventDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalendarEventRepository extends JpaRepository<CalendarEventDto, Integer> {
    List<CalendarEventDto> findByUserPhoneNumber(String userPhoneNumber);
}
