package com.codingcult.settingsconfig.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.settingsconfig.dto.WearableDeviceDTO;
import com.codingcult.settingsconfig.service.WearableDeviceService;

import java.util.List;

@RestController
@RequestMapping("/api/wearables")
public class WearableDeviceController {

    @Autowired
    private WearableDeviceService wearableDeviceService;

    @PostMapping
    public WearableDeviceDTO saveWearable(@RequestBody WearableDeviceDTO wearableDTO) {
        return wearableDeviceService.saveWearable(wearableDTO);
    }

    @PostMapping("/register")
    public WearableDeviceDTO registerDevice(@RequestParam String deviceId, @RequestParam String phoneNumber, @RequestParam String syncFrequency) {
        return wearableDeviceService.registerDevice(deviceId, phoneNumber, syncFrequency.toUpperCase());
    }

    @PutMapping("/updateSync")
    public WearableDeviceDTO updateSyncFrequency(@RequestParam String deviceId, @RequestParam String newFrequency) {
        return wearableDeviceService.updateSyncFrequency(deviceId, newFrequency.toUpperCase());
    }

    @PostMapping("/sync")
    public String syncWithWearable(@RequestParam String deviceId) {
        wearableDeviceService.syncWithWearable(deviceId);
        return "Sync successful for device: " + deviceId;
    }

    @GetMapping
    public List<WearableDeviceDTO> getAllDevices() {
        return wearableDeviceService.getAllDevices();
    }
}
