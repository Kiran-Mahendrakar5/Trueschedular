package com.codingcult.reminder.service;



import java.util.List;

import com.codingcult.reminder.dto.PopupNotificationDto;

public interface PopupNotificationService {
    String triggerPopup(PopupNotificationDto dto);
    List<PopupNotificationDto> getUserNotifications(String phoneNumber);
    String updateStatus(int id, String newStatus);
}
