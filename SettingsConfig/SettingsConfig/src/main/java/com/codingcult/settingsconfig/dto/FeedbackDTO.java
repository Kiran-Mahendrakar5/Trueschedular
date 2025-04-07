package com.codingcult.settingsconfig.dto;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name = "Feedback")
public class FeedbackDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Feedback type cannot be blank")
    @Size(max = 50, message = "Feedback type cannot exceed 50 characters")
    private String feedbackType;

    @Min(value = 1, message = "Rating should be between 1 and 5")
    @Max(value = 5, message = "Rating should be between 1 and 5")
    private int rating;

    @NotBlank(message = "Comments cannot be blank")
    @Size(max = 500, message = "Comments cannot exceed 500 characters")
    private String comments;

    @NotBlank(message = "Phone number cannot be blank")
    @Size(min = 10, max = 15, message = "Phone number should be between 10 and 15 digits")
    private String phoneNumber;

    private boolean isActive = true;

    public FeedbackDTO() {}

    public FeedbackDTO(String feedbackType, int rating, String comments, String phoneNumber) {
        this.feedbackType = feedbackType;
        this.rating = rating;
        this.comments = comments;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
