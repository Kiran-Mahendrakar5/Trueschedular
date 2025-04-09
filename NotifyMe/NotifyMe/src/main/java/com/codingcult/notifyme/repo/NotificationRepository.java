package com.codingcult.notifyme.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.codingcult.notifyme.dto.NotificationDto;
import java.time.LocalDateTime;
import java.util.List;

public interface NotificationRepository extends JpaRepository<NotificationDto, Long> {
    List<NotificationDto> findByEventTimeBefore(LocalDateTime now);
}
