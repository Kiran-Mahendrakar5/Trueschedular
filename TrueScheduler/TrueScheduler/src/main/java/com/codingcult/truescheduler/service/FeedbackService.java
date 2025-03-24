package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.FeedbackDto;

import java.util.List;

public interface FeedbackService {
	public FeedbackDto submitFeedback(FeedbackDto feedback); // Create new feedback

	public FeedbackDto getFeedbackById(Long id); // Retrieve by ID

	public List<FeedbackDto> getAllFeedback(); // Retrieve all feedback

	public FeedbackDto updateFeedback(Long id, FeedbackDto feedback); // Update feedback

	public void deleteFeedback(Long id); // Delete feedback
}
