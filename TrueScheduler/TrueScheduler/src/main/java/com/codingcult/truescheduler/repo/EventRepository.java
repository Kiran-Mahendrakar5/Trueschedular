package com.codingcult.truescheduler.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcult.truescheduler.dto.EventDto;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<EventDto, Long>  {

	public List<EventDto> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

	public List<EventDto> findByReminderSetTrue();

	public List<EventDto> findByEventType(String eventType);
}
