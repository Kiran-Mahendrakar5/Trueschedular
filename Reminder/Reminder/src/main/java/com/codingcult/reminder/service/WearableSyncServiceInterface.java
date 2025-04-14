package com.codingcult.reminder.service;

import com.codingcult.reminder.dto.WearableSyncDto;
import java.util.List;

public interface WearableSyncServiceInterface {

    String syncRemindersWithWearable(WearableSyncDto wearableSyncDto);

    List<WearableSyncDto> getUserWearableSyncData(String userPhoneNumber);

    String removeWearableSyncData(String wearableDeviceId);
}
