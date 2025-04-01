package com.codingcult.friendsdetails.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "friends", uniqueConstraints = @UniqueConstraint(columnNames = {"user_email", "friend_email"}))
public class FriendsDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "User email cannot be blank")
    @Column(name = "user_email", nullable = false)
    private String userEmail; // The user who added this friend

    @NotBlank(message = "Friend email cannot be blank")
    @Column(name = "friend_email", nullable = false)
    private String friendEmail; // Friend's email

    @NotBlank(message = "Friend name cannot be blank")
    @Column(name = "friend_name", nullable = false)
    private String friendName;

    @NotNull(message = "Birthdate cannot be null")
    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "marriage_date")
    private LocalDate marriageDate;

    @Column(name = "location_tracking_enabled")
    private boolean locationTrackingEnabled; // GPS tracking enabled or not

    public FriendsDTO() {
    }

    public FriendsDTO(Long id, String userEmail, String friendEmail, String friendName, LocalDate birthdate, LocalDate marriageDate, boolean locationTrackingEnabled) {
        this.id = id;
        this.userEmail = userEmail;
        this.friendEmail = friendEmail;
        this.friendName = friendName;
        this.birthdate = birthdate;
        this.marriageDate = marriageDate;
        this.locationTrackingEnabled = locationTrackingEnabled;
    }

    @Override
    public String toString() {
        return "FriendsDTO [id=" + id + ", userEmail=" + userEmail + ", friendEmail=" + friendEmail + ", friendName=" + friendName +
                ", birthdate=" + birthdate + ", marriageDate=" + marriageDate + ", locationTrackingEnabled=" + locationTrackingEnabled + "]";
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserEmail() { return userEmail; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }

    public String getFriendEmail() { return friendEmail; }
    public void setFriendEmail(String friendEmail) { this.friendEmail = friendEmail; }

    public String getFriendName() { return friendName; }
    public void setFriendName(String friendName) { this.friendName = friendName; }

    public LocalDate getBirthdate() { return birthdate; }
    public void setBirthdate(LocalDate birthdate) { this.birthdate = birthdate; }

    public LocalDate getMarriageDate() { return marriageDate; }
    public void setMarriageDate(LocalDate marriageDate) { this.marriageDate = marriageDate; }

    public boolean isLocationTrackingEnabled() { return locationTrackingEnabled; }
    public void setLocationTrackingEnabled(boolean locationTrackingEnabled) { this.locationTrackingEnabled = locationTrackingEnabled; }
}
