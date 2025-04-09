package com.codingcult.friendsdetails.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "friends")
public class FriendsDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Friend name cannot be blank")
    @Column(name = "friend_name", nullable = false)
    private String friendName;

    @NotBlank(message = "Phone number cannot be blank")
    @Column(name = "phone_number", nullable = false, unique = true)
    private String phoneNumber;

    @NotNull(message = "Birthdate cannot be null")
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "marriage_date")
    private LocalDate marriageDate;

    @Column(name = "location_tracking_enabled")
    private boolean locationTrackingEnabled;

    @Column(name = "is_active")
    private boolean isActive = true;

    public FriendsDTO() {}

    public FriendsDTO(Long id, String friendName, String phoneNumber, LocalDate birthdate, LocalDate marriageDate, boolean locationTrackingEnabled, boolean isActive) {
        this.id = id;
        this.friendName = friendName;
        this.phoneNumber = phoneNumber;
        this.birthdate = birthdate;
        this.marriageDate = marriageDate;
        this.locationTrackingEnabled = locationTrackingEnabled;
        this.isActive = isActive;
    }

	@Override
	public String toString() {
		return "FriendsDTO [id=" + id + ", friendName=" + friendName + ", phoneNumber=" + phoneNumber + ", birthdate="
				+ birthdate + ", marriageDate=" + marriageDate + ", locationTrackingEnabled=" + locationTrackingEnabled
				+ ", isActive=" + isActive + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFriendName() {
		return friendName;
	}

	public void setFriendName(String friendName) {
		this.friendName = friendName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public LocalDate getMarriageDate() {
		return marriageDate;
	}

	public void setMarriageDate(LocalDate marriageDate) {
		this.marriageDate = marriageDate;
	}

	public boolean isLocationTrackingEnabled() {
		return locationTrackingEnabled;
	}

	public void setLocationTrackingEnabled(boolean locationTrackingEnabled) {
		this.locationTrackingEnabled = locationTrackingEnabled;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
    
    

    // toString(), getters and setters
    // ...
}
