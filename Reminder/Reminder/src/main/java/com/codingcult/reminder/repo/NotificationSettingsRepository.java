package com.codingcult.reminder.repo;

import com.codingcult.reminder.dto.NotificationSettingsDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationSettingsRepository extends JpaRepository<NotificationSettingsDto, Integer> {
    NotificationSettingsDto findByUserPhoneNumber(String phoneNumber);
}
