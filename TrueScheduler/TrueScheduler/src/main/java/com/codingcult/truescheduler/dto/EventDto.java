package com.codingcult.truescheduler.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.ElementCollection;
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
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private boolean reminderSet;

    private String eventType;   // Event, Birthday, Task, To-Do List
    private String location;    // Added location field

    @ElementCollection
    private List<String> people;  // List of people attending

    @Override
    public String toString() {
        return "EventDto [id=" + id + ", title=" + title + ", startTime=" + startTime +
               ", endTime=" + endTime + ", reminderSet=" + reminderSet + 
               ", eventType=" + eventType + ", location=" + location + 
               ", people=" + people + "]";
    }

	public EventDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EventDto(Long id, String title, LocalDateTime startTime, LocalDateTime endTime, boolean reminderSet,
			String eventType, String location, List<String> people) {
		super();
		this.id = id;
		this.title = title;
		this.startTime = startTime;
		this.endTime = endTime;
		this.reminderSet = reminderSet;
		this.eventType = eventType;
		this.location = location;
		this.people = people;
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

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<String> getPeople() {
		return people;
	}

	public void setPeople(List<String> people) {
		this.people = people;
	}
    
    
}


//POST http://localhost:8088/api/events → Add a new event.
//GET http://localhost:8088/api/events → Retrieve all events.
//GET http://localhost:8088/api/events/1 → Retrieve event by ID.
//DELETE http://localhost:8088/api/events/1 → Delete event by ID.
//GET http://localhost:8088/api/events/reminders → Retrieve all reminders.
//GET http://localhost:8088/api/events/type/Birthday → Retrieve events by type.
