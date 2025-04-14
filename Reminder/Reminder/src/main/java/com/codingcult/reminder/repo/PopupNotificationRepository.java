package com.codingcult.reminder.repo;


import org.springframework.data.jpa.repository.JpaRepository;

import com.codingcult.reminder.dto.PopupNotificationDto;

import java.util.List;

public interface PopupNotificationRepository extends JpaRepository<PopupNotificationDto, Integer> {
    List<PopupNotificationDto> findByUserPhoneNumber(String phoneNumber);
}
