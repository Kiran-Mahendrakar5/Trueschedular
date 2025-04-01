package com.codingcult.settingsconfig.service;


import java.util.List;

import com.codingcult.settingsconfig.dto.WearableDeviceDTO;

public interface WearableDeviceService {
	public WearableDeviceDTO saveWearable(WearableDeviceDTO wearableDTO);
    WearableDeviceDTO registerDevice(String deviceId, String syncFrequency);
    WearableDeviceDTO updateSyncFrequency(String deviceId, String newFrequency);
    void syncWithWearable(String deviceId);
    List<WearableDeviceDTO> getAllDevices();
}
