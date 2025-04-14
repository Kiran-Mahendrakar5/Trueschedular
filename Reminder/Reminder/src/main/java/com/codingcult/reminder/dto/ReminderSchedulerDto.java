package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reminder_schedules")
public class ReminderSchedulerDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userMobile;
    private String reminderMessage;
    private LocalDateTime scheduleTime;
    private boolean isRecurring;
    private String repeatCycle; // e.g., DAILY, WEEKLY
    private boolean isActive = true;

    public ReminderSchedulerDto() {}

    public ReminderSchedulerDto(int id, String userMobile, String reminderMessage, LocalDateTime scheduleTime,
                                 boolean isRecurring, String repeatCycle, boolean isActive) {
        this.id = id;
        this.userMobile = userMobile;
        this.reminderMessage = reminderMessage;
        this.scheduleTime = scheduleTime;
        this.isRecurring = isRecurring;
        this.repeatCycle = repeatCycle;
        this.isActive = isActive;
    }

    // Getters and Setters

    @Override
    public String toString() {
        return "ReminderSchedulerDto{" +
                "id=" + id +
                ", userMobile='" + userMobile + '\'' +
                ", reminderMessage='" + reminderMessage + '\'' +
                ", scheduleTime=" + scheduleTime +
                ", isRecurring=" + isRecurring +
                ", repeatCycle='" + repeatCycle + '\'' +
                ", isActive=" + isActive +
                '}';
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserMobile() {
		return userMobile;
	}

	public void setUserMobile(String userMobile) {
		this.userMobile = userMobile;
	}

	public String getReminderMessage() {
		return reminderMessage;
	}

	public void setReminderMessage(String reminderMessage) {
		this.reminderMessage = reminderMessage;
	}

	public LocalDateTime getScheduleTime() {
		return scheduleTime;
	}

	public void setScheduleTime(LocalDateTime scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	public boolean isRecurring() {
		return isRecurring;
	}

	public void setRecurring(boolean isRecurring) {
		this.isRecurring = isRecurring;
	}

	public String getRepeatCycle() {
		return repeatCycle;
	}

	public void setRepeatCycle(String repeatCycle) {
		this.repeatCycle = repeatCycle;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

   
}
