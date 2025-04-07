package com.codingcult.settingsconfig.service;

import com.codingcult.settingsconfig.dto.FeedbackDTO;
import com.codingcult.settingsconfig.repo.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    public FeedbackDTO createFeedback(FeedbackDTO feedbackDTO) {
        return feedbackRepository.save(feedbackDTO);
    }

    @Override
    public List<FeedbackDTO> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    @Override
    public FeedbackDTO getFeedbackById(Long id) {
        Optional<FeedbackDTO> feedback = feedbackRepository.findById(id);
        return feedback.orElse(null);
    }

    @Override
    public FeedbackDTO updateFeedback(Long id, FeedbackDTO feedbackDTO) {
        if (feedbackRepository.existsById(id)) {
            feedbackDTO.setId(id);
            return feedbackRepository.save(feedbackDTO);
        }
        return null;
    }

    @Override
    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
