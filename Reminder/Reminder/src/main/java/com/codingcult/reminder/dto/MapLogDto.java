package com.codingcult.reminder.dto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "map_logs")
public class MapLogDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userPhoneNumber;
    private double latitude;
    private double longitude;
    private LocalDateTime timestamp;
    private String locationLabel; // e.g., Home, Office, Park (optional)

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getLocationLabel() {
        return locationLabel;
    }

    public void setLocationLabel(String locationLabel) {
        this.locationLabel = locationLabel;
    }

	public MapLogDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MapLogDto(int id, String userPhoneNumber, double latitude, double longitude, LocalDateTime timestamp,
			String locationLabel) {
		super();
		this.id = id;
		this.userPhoneNumber = userPhoneNumber;
		this.latitude = latitude;
		this.longitude = longitude;
		this.timestamp = timestamp;
		this.locationLabel = locationLabel;
	}

	@Override
	public String toString() {
		return "MapLogDto [id=" + id + ", userPhoneNumber=" + userPhoneNumber + ", latitude=" + latitude
				+ ", longitude=" + longitude + ", timestamp=" + timestamp + ", locationLabel=" + locationLabel + "]";
	}
    
    
}
