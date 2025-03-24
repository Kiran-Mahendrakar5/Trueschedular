package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.FeedbackDto;
import com.codingcult.truescheduler.repo.FeedbackRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository repository;

    // Java 8 compatible
    private static final List<String> ALLOWED_TYPES = Arrays.asList("Complaint", "Suggestion", "Inquiry");

    @Override
    public FeedbackDto submitFeedback(FeedbackDto feedback) {
        validateFeedback(feedback);
        return repository.save(feedback);
    }

    @Override
    public FeedbackDto getFeedbackById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Feedback not found with ID: " + id));
    }

    @Override
    public List<FeedbackDto> getAllFeedback() {
        return repository.findAll();
    }

    @Override
    public FeedbackDto updateFeedback(Long id, FeedbackDto feedback) {
        FeedbackDto existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Feedback not found with ID: " + id));

        validateFeedback(feedback);
        existing.setFeedbackType(feedback.getFeedbackType());
        existing.setRating(feedback.getRating());
        existing.setComments(feedback.getComments());

        return repository.save(existing);
    }

    @Override
    public void deleteFeedback(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Feedback not found with ID: " + id);
        }
        repository.deleteById(id);
    }

    // Improved validation for Java 8 compatibility
    private void validateFeedback(FeedbackDto feedback) {
        if (feedback.getFeedbackType() == null || !ALLOWED_TYPES.contains(feedback.getFeedbackType())) {
            throw new IllegalArgumentException("Invalid feedback type: " + feedback.getFeedbackType() +
                    ". Allowed types: Complaint, Suggestion, Inquiry");
        }

        if (feedback.getRating() < 1 || feedback.getRating() > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }

        if (feedback.getComments() == null || feedback.getComments().trim().isEmpty()) {
            throw new IllegalArgumentException("Comments cannot be empty");
        }
    }
}
