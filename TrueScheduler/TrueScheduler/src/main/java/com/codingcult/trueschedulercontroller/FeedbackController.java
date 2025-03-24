package com.codingcult.trueschedulercontroller;

import com.codingcult.truescheduler.dto.FeedbackDto;
import com.codingcult.truescheduler.service.FeedbackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private FeedbackService service;


    @PostMapping
    public FeedbackDto submitFeedback(@Valid @RequestBody FeedbackDto feedback) {
        return service.submitFeedback(feedback);
    }

    // Get feedback by ID
    @GetMapping("/{id}")
    public FeedbackDto getFeedbackById(@PathVariable Long id) {
        return service.getFeedbackById(id);
    }

    // Get all feedback
    @GetMapping
    public List<FeedbackDto> getAllFeedback() {
        return service.getAllFeedback();
    }

    
    @PutMapping("/{id}")
    public FeedbackDto updateFeedback(@PathVariable Long id, @Valid @RequestBody FeedbackDto feedback) {
        return service.updateFeedback(id, feedback);
    }

    // Delete feedback
    @DeleteMapping("/{id}")
    public String deleteFeedback(@PathVariable Long id) {
        service.deleteFeedback(id);
        return "Feedback deleted successfully.";
    }
}
