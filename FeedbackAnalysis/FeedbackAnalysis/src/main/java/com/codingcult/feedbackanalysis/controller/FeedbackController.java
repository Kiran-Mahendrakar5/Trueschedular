package com.codingcult.feedbackanalysis.controller;

import com.codingcult.feedbackanalysis.dto.FeedbackDTO;
import com.codingcult.feedbackanalysis.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping
    public FeedbackDTO submitFeedback(@RequestBody FeedbackDTO feedback) {
        return feedbackService.submitFeedback(feedback);
    }

    @GetMapping
    public List<FeedbackDTO> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }
}
