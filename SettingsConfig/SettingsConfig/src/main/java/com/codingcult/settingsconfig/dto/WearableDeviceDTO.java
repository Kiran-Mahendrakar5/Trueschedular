package com.codingcult.settingsconfig.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wearable_devices")
public class WearableDeviceDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "device_id", unique = true, nullable = false)
    private String deviceId;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "sync_frequency", nullable = false)
    private String syncFrequency;

    @Column(name = "last_sync_time")
    private LocalDateTime lastSyncTime;

    @Column(name = "status")
    private String status;

    @Column(name = "is_active")
    private boolean isActive = true;

    public WearableDeviceDTO() {}

    public WearableDeviceDTO(String deviceId, String phoneNumber, String syncFrequency, LocalDateTime lastSyncTime, String status) {
        this.deviceId = deviceId;
        this.phoneNumber = phoneNumber;
        this.syncFrequency = syncFrequency;
        this.lastSyncTime = lastSyncTime;
        this.status = status;
        this.isActive = true;
    }

    // Getters and Setters

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDeviceId() { return deviceId; }
    public void setDeviceId(String deviceId) { this.deviceId = deviceId; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getSyncFrequency() { return syncFrequency; }
    public void setSyncFrequency(String syncFrequency) { this.syncFrequency = syncFrequency; }

    public LocalDateTime getLastSyncTime() { return lastSyncTime; }
    public void setLastSyncTime(LocalDateTime lastSyncTime) { this.lastSyncTime = lastSyncTime; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }
}
