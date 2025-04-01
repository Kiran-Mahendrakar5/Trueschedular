package com.codingcult.settingsconfig.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notification_settings")
public class NotificationSettingsDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    @Column(name = "notification_sound")
    private boolean notificationSound; // true if sound is enabled, false otherwise

    @Column(name = "vibration")
    private boolean vibration; // true if vibration is enabled, false otherwise

    @Column(name = "priority")
    private String priority; // HIGH, MEDIUM, LOW

    @Column(name = "notifications_read")
    private boolean notificationsRead; // to track if notifications are read or unread

    @Column(name = "last_notification_time")
    private LocalDateTime lastNotificationTime;

    public NotificationSettingsDTO() {}

    public NotificationSettingsDTO(Long userId, boolean notificationSound, boolean vibration, String priority, boolean notificationsRead, LocalDateTime lastNotificationTime) {
        this.userId = userId;
        this.notificationSound = notificationSound;
        this.vibration = vibration;
        this.priority = priority;
        this.notificationsRead = notificationsRead;
        this.lastNotificationTime = lastNotificationTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
