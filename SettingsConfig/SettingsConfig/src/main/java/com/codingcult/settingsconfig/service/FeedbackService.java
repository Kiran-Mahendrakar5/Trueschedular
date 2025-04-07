package com.codingcult.settingsconfig.service;

import com.codingcult.settingsconfig.dto.FeedbackDTO;
import java.util.List;

public interface FeedbackService {
    FeedbackDTO createFeedback(FeedbackDTO feedbackDTO);
    List<FeedbackDTO> getAllFeedback();
    FeedbackDTO getFeedbackById(Long id);
    FeedbackDTO updateFeedback(Long id, FeedbackDTO feedbackDTO);
    void deleteFeedback(Long id);
}