package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "reminders")
public class ReminderDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String category; // Bill, User, etc.
    private LocalDateTime reminderTime;
    private boolean isRecurring;
    private String repeatCycle; // DAILY, WEEKLY, etc.
    private boolean isActive = true;

    public ReminderDto() {}

    public ReminderDto(int id, String title, String category, LocalDateTime reminderTime, boolean isRecurring, String repeatCycle, boolean isActive) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.reminderTime = reminderTime;
        this.isRecurring = isRecurring;
        this.repeatCycle = repeatCycle;
        this.isActive = isActive;
    }

    // Getters and Setters

    @Override
    public String toString() {
        return "ReminderDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", reminderTime=" + reminderTime +
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDateTime getReminderTime() {
		return reminderTime;
	}

	public void setReminderTime(LocalDateTime reminderTime) {
		this.reminderTime = reminderTime;
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
