package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.ReminderNotificationsDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ReminderNotificationsRepository extends JpaRepository<ReminderNotificationsDTO, Long> {
    List<ReminderNotificationsDTO> findByIsActiveTrue();
    List<ReminderNotificationsDTO> findByPhoneNumber(String phoneNumber);
}
