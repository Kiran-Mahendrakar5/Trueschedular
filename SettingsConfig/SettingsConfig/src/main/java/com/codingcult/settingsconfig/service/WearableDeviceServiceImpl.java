package com.codingcult.settingsconfig.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.codingcult.settingsconfig.dto.WearableDeviceDTO;
import com.codingcult.settingsconfig.repo.WearableDeviceRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WearableDeviceServiceImpl implements WearableDeviceService {

    @Autowired
    private WearableDeviceRepository wearableDeviceRepository;
    
    @Override
    public WearableDeviceDTO saveWearable(WearableDeviceDTO wearableDTO) {
        return wearableDeviceRepository.save(wearableDTO);
    }


    @Override
    public WearableDeviceDTO registerDevice(String deviceId, String syncFrequency) {
        Optional<WearableDeviceDTO> existingDevice = wearableDeviceRepository.findByDeviceId(deviceId);
        if (existingDevice.isPresent()) {
            throw new RuntimeException("Device already registered.");
        }

        WearableDeviceDTO device = new WearableDeviceDTO(deviceId, syncFrequency, LocalDateTime.now(), "ACTIVE");
        return wearableDeviceRepository.save(device);
    }

    @Override
    public WearableDeviceDTO updateSyncFrequency(String deviceId, String newFrequency) {
        WearableDeviceDTO device = wearableDeviceRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));

        device.setSyncFrequency(newFrequency);
        return wearableDeviceRepository.save(device);
    }

    @Override
    public void syncWithWearable(String deviceId) {
        WearableDeviceDTO device = wearableDeviceRepository.findByDeviceId(deviceId)
                .orElseThrow(() -> new RuntimeException("Device not found"));

        device.setLastSyncTime(LocalDateTime.now());
        wearableDeviceRepository.save(device);
        System.out.println("Synced reminders with device: " + deviceId);
    }

    @Override
    public List<WearableDeviceDTO> getAllDevices() {
        return wearableDeviceRepository.findAll();
    }

    // Scheduled sync every 6 hours
    @Scheduled(fixedRate = 21600000)
    public void scheduledSync() {
        List<WearableDeviceDTO> devices = wearableDeviceRepository.findAll();
        for (WearableDeviceDTO device : devices) {
            syncWithWearable(device.getDeviceId());
        }
    }
}
