package com.codingcult.feedback.dto;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedbacks")
public class FeedBackDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String feedbackType; // Complaint, Suggestion, Inquiry
    private int rating; // 1 to 5
    private String comment;
    private String userMobile; // who gave feedback

    @Column(name = "created_time", updatable = false)
    private String createdTime;

    public FeedBackDto() {
    }

    public FeedBackDto(String feedbackType, int rating, String comment, String userMobile, String createdTime) {
        this.feedbackType = feedbackType;
        this.rating = rating;
        this.comment = comment;
        this.userMobile = userMobile;
        this.createdTime = createdTime;
    }

    // Getters and Setters

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFeedbackType() { return feedbackType; }
    public void setFeedbackType(String feedbackType) { this.feedbackType = feedbackType; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public String getUserMobile() { return userMobile; }
    public void setUserMobile(String userMobile) { this.userMobile = userMobile; }

    public String getCreatedTime() { return createdTime; }
    public void setCreatedTime(String createdTime) { this.createdTime = createdTime; }

    @Override
    public String toString() {
        return "FeedBackDto{" +
                "id=" + id +
                ", feedbackType='" + feedbackType + '\'' +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", createdTime='" + createdTime + '\'' +
                '}';
    }
}
