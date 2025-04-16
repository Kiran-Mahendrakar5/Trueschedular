package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.LocationAlertDto;
import com.codingcult.reminder.dto.ReminderDto;
import com.codingcult.reminder.dto.WearableSyncDto;
import java.util.List;

public interface WearableSyncServiceInterface {

    String syncRemindersWithWearable(WearableSyncDto wearableSyncDto);

    List<WearableSyncDto> getUserWearableSyncData(String userPhoneNumber);

    String removeWearableSyncData(String wearableDeviceId);

    List<ReminderDto> getRemindersFromReminderService(String phoneNumber);

    List<ReminderDto> syncReminders(String phoneNumber);

    List<LocationAlertDto> syncLocationAlerts(String phoneNumber);
}
