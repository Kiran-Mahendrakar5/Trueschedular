package com.codingcult.settingsconfig.dto;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Feedback")
public class FeedbackDTO implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // Unique identifier for Feedback entry

    // Validates that feedback type is not blank and restricts to specific values
    @NotBlank(message = "Feedback type cannot be blank")
    @Size(max = 50, message = "Feedback type cannot exceed 50 characters")
    private String feedbackType;    // Complaint, Suggestion, or Inquiry

    // Validates that rating is between 1 and 5 (inclusive)
    @Min(value = 1, message = "Rating should be between 1 and 5")
    @Max(value = 5, message = "Rating should be between 1 and 5")
    private int rating;             // Rating from 1 to 5 stars

    // Validates that comments are not blank and provides a maximum length
    @NotBlank(message = "Comments cannot be blank")
    @Size(max = 500, message = "Comments cannot exceed 500 characters")
    private String comments;        // Comments/Feedback description

    // Constructor
    public FeedbackDTO(String feedbackType, int rating, String comments) {
        this.feedbackType = feedbackType;
        this.rating = rating;
        this.comments = comments;
    }

    // Getters and Setters
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

    @Override
    public String toString() {
        return "FeedbackDTO{" +
                "id=" + id +
                ", feedbackType='" + feedbackType + '\'' +
                ", rating=" + rating +
                ", comments='" + comments + '\'' +
                '}';
    }
}
