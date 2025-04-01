package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.ReminderNotificationsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReminderNotificationsRepository extends JpaRepository<ReminderNotificationsDTO, Long> {

    List<ReminderNotificationsDTO> findByUserEmail(String userEmail);

    List<ReminderNotificationsDTO> findByNotificationType(String notificationType);

    List<ReminderNotificationsDTO> findByReminderDateBeforeAndStatus(LocalDateTime now, String status);
}
