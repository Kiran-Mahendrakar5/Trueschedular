package com.codingcult.feedbackanalysis.dto;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "feedbacks")
public class FeedbackDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Feedback type is required")
    private String feedbackType; // Complaint, Suggestion, Inquiry

    @Min(1)
    @Max(5)
    private int rating;

    @NotBlank(message = "Feedback description cannot be empty")
    private String description;

    public FeedbackDTO() {}

    public FeedbackDTO(Long id, String feedbackType, int rating, String description) {
        this.id = id;
        this.feedbackType = feedbackType;
        this.rating = rating;
        this.description = description;
    }

    // Getters & Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFeedbackType() { return feedbackType; }

    public void setFeedbackType(String feedbackType) { this.feedbackType = feedbackType; }

    public int getRating() { return rating; }

    public void setRating(int rating) { this.rating = rating; }

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }
}
