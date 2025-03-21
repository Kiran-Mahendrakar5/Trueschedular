package com.codingcult.truescheduler.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "event_dto")
public class EventDto implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	private boolean reminderSet;

	public EventDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventDto(Long id, String title, String description, LocalDateTime startTime, LocalDateTime endTime,
			boolean reminderSet) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.startTime = startTime;
		this.endTime = endTime;
		this.reminderSet = reminderSet;
	}

	@Override
	public String toString() {
		return "EventDto [id=" + id + ", title=" + title + ", description=" + description + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", reminderSet=" + reminderSet + "]";
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

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public boolean isReminderSet() {
		return reminderSet;
	}

	public void setReminderSet(boolean reminderSet) {
		this.reminderSet = reminderSet;
	}

}
