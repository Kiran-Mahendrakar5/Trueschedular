package com.codingcult.truescheduler.dto;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Feedback type cannot be blank")
    @Column(name = "feedback_type")
    private String feedbackType;   // Complaint, Suggestion, Inquiry

    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    private int rating;             // 1-5 stars

    @NotBlank(message = "Comments cannot be empty")
    private String comments;        // User comments

	public FeedbackDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FeedbackDto(Long id, @NotBlank(message = "Feedback type cannot be blank") String feedbackType,
			@Min(value = 1, message = "Rating must be between 1 and 5") @Max(value = 5, message = "Rating must be between 1 and 5") int rating,
			@NotBlank(message = "Comments cannot be empty") String comments) {
		super();
		this.id = id;
		this.feedbackType = feedbackType;
		this.rating = rating;
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "FeedbackDto [id=" + id + ", feedbackType=" + feedbackType + ", rating=" + rating + ", comments="
				+ comments + "]";
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
    
    
    
    
}

