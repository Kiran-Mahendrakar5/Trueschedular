package com.codingcult.reminder.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.reminder.dto.PopupNotificationDto;
import com.codingcult.reminder.enums.NotificationStatus;
import com.codingcult.reminder.repo.PopupNotificationRepository;

import java.util.List;

@Service
public class PopupNotificationServiceImpl implements PopupNotificationService {

    @Autowired
    private PopupNotificationRepository repository;

    @Override
    public String triggerPopup(PopupNotificationDto dto) {
        dto.setStatus(NotificationStatus.PENDING);
        repository.save(dto);
        return "Popup notification triggered!";
    }

    @Override
    public List<PopupNotificationDto> getUserNotifications(String phoneNumber) {
        return repository.findByUserPhoneNumber(phoneNumber);
    }

    @Override
    public String updateStatus(int id, String newStatus) {
        PopupNotificationDto notification = repository.findById(id).orElse(null);
        if (notification != null) {
            notification.setStatus(NotificationStatus.valueOf(newStatus.toUpperCase()));
            repository.save(notification);
            return "Status updated.";
        }
        return "Notification not found.";
    }
}
