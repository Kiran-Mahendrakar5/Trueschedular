package com.codingcult.settingsconfig.controller;

import com.codingcult.settingsconfig.dto.FeedbackDTO;
import com.codingcult.settingsconfig.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public FeedbackDTO createFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        return feedbackService.createFeedback(feedbackDTO);
    }

    @GetMapping
    public List<FeedbackDTO> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @GetMapping("/{id}")
    public FeedbackDTO getFeedbackById(@PathVariable Long id) {
        return feedbackService.getFeedbackById(id);
    }

    @PutMapping("/{id}")
    public FeedbackDTO updateFeedback(@PathVariable Long id, @RequestBody FeedbackDTO feedbackDTO) {
        return feedbackService.updateFeedback(id, feedbackDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteFeedback(@PathVariable Long id) {
        feedbackService.deleteFeedback(id);
    }
} 
