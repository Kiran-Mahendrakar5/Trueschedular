package com.codingcult.settingsconfig.service;

import java.util.List;
import com.codingcult.settingsconfig.dto.WearableDeviceDTO;

public interface WearableDeviceService {
    WearableDeviceDTO saveWearable(WearableDeviceDTO wearableDTO);
    WearableDeviceDTO registerDevice(String deviceId, String phoneNumber, String syncFrequency);
    WearableDeviceDTO updateSyncFrequency(String deviceId, String newFrequency);
    void syncWithWearable(String deviceId);
    List<WearableDeviceDTO> getAllDevices();
}
