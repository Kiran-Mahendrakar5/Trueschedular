package com.codingcult.settingsconfig.service;

import com.codingcult.settingsconfig.dto.FeedbackDTO;
import java.util.List;

public interface FeedbackService {
    // Create feedback
    FeedbackDTO createFeedback(FeedbackDTO feedbackDTO);

    // Get all feedback
    List<FeedbackDTO> getAllFeedback();

    // Get feedback by ID
    FeedbackDTO getFeedbackById(Long id);

    // Update feedback
    FeedbackDTO updateFeedback(Long id, FeedbackDTO feedbackDTO);

    // Delete feedback
    void deleteFeedback(Long id);
}
