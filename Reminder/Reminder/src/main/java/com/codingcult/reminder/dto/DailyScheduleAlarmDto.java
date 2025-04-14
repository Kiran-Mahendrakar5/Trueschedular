package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "daily_schedule_alarms")
public class DailyScheduleAlarmDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private String[] daysOfWeek; // ["MONDAY", "TUESDAY", ...]
    private LocalTime alarmTime;
    private boolean vibrationEnabled;
    private boolean soundEnabled;
    private boolean isActive = true;

    public DailyScheduleAlarmDto() {}

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getDaysOfWeek() {
        return daysOfWeek;
    }

    public void setDaysOfWeek(String[] daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public LocalTime getAlarmTime() {
        return alarmTime;
    }

    public void setAlarmTime(LocalTime alarmTime) {
        this.alarmTime = alarmTime;
    }

    public boolean isVibrationEnabled() {
        return vibrationEnabled;
    }

    public void setVibrationEnabled(boolean vibrationEnabled) {
        this.vibrationEnabled = vibrationEnabled;
    }

    public boolean isSoundEnabled() {
        return soundEnabled;
    }

    public void setSoundEnabled(boolean soundEnabled) {
        this.soundEnabled = soundEnabled;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "DailyScheduleAlarmDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", daysOfWeek=" + String.join(",", daysOfWeek) +
                ", alarmTime=" + alarmTime +
                ", vibrationEnabled=" + vibrationEnabled +
                ", soundEnabled=" + soundEnabled +
                ", isActive=" + isActive +
                '}';
    }
}
