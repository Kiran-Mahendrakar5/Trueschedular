package com.codingcult.truescheduler.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "daily_event")
public class DailyEventDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;               // Event title
    private String description;         // Event description
    private LocalDateTime eventTime;    // Event time
    private boolean isAlarmEnabled;     // Alarm status
    private boolean isPaused;           // Pause status
    private boolean isStopped;          // Stop status
    private int remindLaterMinutes;     // Remind later in minutes

    @Override
    public String toString() {
        return "DailyEventDto [id=" + id + ", title=" + title + 
               ", description=" + description + ", eventTime=" + eventTime + 
               ", isAlarmEnabled=" + isAlarmEnabled + 
               ", isPaused=" + isPaused + 
               ", isStopped=" + isStopped + 
               ", remindLaterMinutes=" + remindLaterMinutes + "]";
    }

	public DailyEventDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DailyEventDto(Long id, String title, String description, LocalDateTime eventTime, boolean isAlarmEnabled,
			boolean isPaused, boolean isStopped, int remindLaterMinutes) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.eventTime = eventTime;
		this.isAlarmEnabled = isAlarmEnabled;
		this.isPaused = isPaused;
		this.isStopped = isStopped;
		this.remindLaterMinutes = remindLaterMinutes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public LocalDateTime getEventTime() {
		return eventTime;
	}

	public void setEventTime(LocalDateTime eventTime) {
		this.eventTime = eventTime;
	}

	public boolean isAlarmEnabled() {
		return isAlarmEnabled;
	}

	public void setAlarmEnabled(boolean isAlarmEnabled) {
		this.isAlarmEnabled = isAlarmEnabled;
	}

	public boolean isPaused() {
		return isPaused;
	}

	public void setPaused(boolean isPaused) {
		this.isPaused = isPaused;
	}

	public boolean isStopped() {
		return isStopped;
	}

	public void setStopped(boolean isStopped) {
		this.isStopped = isStopped;
	}

	public int getRemindLaterMinutes() {
		return remindLaterMinutes;
	}

	public void setRemindLaterMinutes(int remindLaterMinutes) {
		this.remindLaterMinutes = remindLaterMinutes;
	}
	
	
}
