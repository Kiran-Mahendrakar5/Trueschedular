package com.codingcult.feedbackanalysis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.feedbackanalysis.dto.FeedbackDTO;
import com.codingcult.feedbackanalysis.repo.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    @Override
    public FeedbackDTO submitFeedback(FeedbackDTO feedback) {
        return repository.save(feedback);
    }

    @Override
    public List<FeedbackDTO> getAllFeedback() {
        return repository.findAll();
    }
}