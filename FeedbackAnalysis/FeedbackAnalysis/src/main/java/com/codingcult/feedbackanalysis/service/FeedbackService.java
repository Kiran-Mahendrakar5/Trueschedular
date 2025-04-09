package com.codingcult.feedbackanalysis.service;

import java.util.List;

import com.codingcult.feedbackanalysis.dto.FeedbackDTO;

public interface FeedbackService {
    FeedbackDTO submitFeedback(FeedbackDTO feedback);
    List<FeedbackDTO> getAllFeedback();
}
