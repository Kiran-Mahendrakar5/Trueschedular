package com.codingcult.eventdetails.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class EventsDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "User email cannot be blank")
    @Column(name = "user_email", nullable = false)
    private String userEmail;

    @NotBlank(message = "Event title cannot be blank")
    @Column(name = "event_title", nullable = false)
    private String eventTitle;

    @NotNull(message = "Event time cannot be null")
    @Column(name = "event_time", nullable = false)
    private LocalDateTime eventTime;

    @NotBlank(message = "Location cannot be blank")
    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "notify_before_minutes")
    private Integer notifyBeforeMinutes; // Notify user X minutes before event

    public EventsDTO() {
        super();
    }

    public EventsDTO(Long id, String userEmail, String eventTitle, LocalDateTime eventTime, String location, Integer notifyBeforeMinutes) {
        this.id = id;
        this.userEmail = userEmail;
        this.eventTitle = eventTitle;
        this.eventTime = eventTime;
        this.location = location;
        this.notifyBeforeMinutes = notifyBeforeMinutes;
    }

    @Override
    public String toString() {
        return "EventsDTO [id=" + id + ", userEmail=" + userEmail + ", eventTitle=" + eventTitle +
                ", eventTime=" + eventTime + ", location=" + location + ", notifyBeforeMinutes=" + notifyBeforeMinutes + "]";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getEventTitle() { return eventTitle; }
    public void setEventTitle(String eventTitle) { this.eventTitle = eventTitle; }

    public LocalDateTime getEventTime() { return eventTime; }
    public void setEventTime(LocalDateTime eventTime) { this.eventTime = eventTime; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public Integer getNotifyBeforeMinutes() { return notifyBeforeMinutes; }
    public void setNotifyBeforeMinutes(Integer notifyBeforeMinutes) { this.notifyBeforeMinutes = notifyBeforeMinutes; }
}
