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
    private String deviceId; // Smartwatch ID or Model

    @Column(name = "sync_frequency", nullable = false)
    private String syncFrequency; // "DAILY" or "WEEKLY"

    @Column(name = "last_sync_time")
    private LocalDateTime lastSyncTime;

    @Column(name = "status")
    private String status; // "ACTIVE" or "INACTIVE"

    public WearableDeviceDTO() {}

    public WearableDeviceDTO(String deviceId, String syncFrequency, LocalDateTime lastSyncTime, String status) {
        this.deviceId = deviceId;
        this.syncFrequency = syncFrequency;
        this.lastSyncTime = lastSyncTime;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getSyncFrequency() {
        return syncFrequency;
    }

    public void setSyncFrequency(String syncFrequency) {
        this.syncFrequency = syncFrequency;
    }

    public LocalDateTime getLastSyncTime() {
        return lastSyncTime;
    }

    public void setLastSyncTime(LocalDateTime lastSyncTime) {
        this.lastSyncTime = lastSyncTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
