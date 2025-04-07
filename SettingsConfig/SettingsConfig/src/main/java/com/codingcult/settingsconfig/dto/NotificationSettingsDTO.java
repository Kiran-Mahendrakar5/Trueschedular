package com.codingcult.settingsconfig.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification_settings")
public class NotificationSettingsDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "notification_sound")
    private boolean notificationSound;

    @Column(name = "vibration")
    private boolean vibration;

    @Column(name = "priority")
    private String priority;

    @Column(name = "notifications_read")
    private boolean notificationsRead;

    @Column(name = "last_notification_time")
    private LocalDateTime lastNotificationTime;

    @Column(name = "is_active")
    private boolean isActive = true;

    public NotificationSettingsDTO() {}

    public NotificationSettingsDTO(String phoneNumber, boolean notificationSound, boolean vibration, String priority, boolean notificationsRead, LocalDateTime lastNotificationTime, boolean isActive) {
        this.phoneNumber = phoneNumber;
        this.notificationSound = notificationSound;
        this.vibration = vibration;
        this.priority = priority;
        this.notificationsRead = notificationsRead;
        this.lastNotificationTime = lastNotificationTime;
        this.isActive = isActive;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isNotificationSound() {
        return notificationSound;
    }

    public void setNotificationSound(boolean notificationSound) {
        this.notificationSound = notificationSound;
    }

    public boolean isVibration() {
        return vibration;
    }

    public void setVibration(boolean vibration) {
        this.vibration = vibration;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isNotificationsRead() {
        return notificationsRead;
    }

    public void setNotificationsRead(boolean notificationsRead) {
        this.notificationsRead = notificationsRead;
    }

    public LocalDateTime getLastNotificationTime() {
        return lastNotificationTime;
    }

    public void setLastNotificationTime(LocalDateTime lastNotificationTime) {
        this.lastNotificationTime = lastNotificationTime;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}