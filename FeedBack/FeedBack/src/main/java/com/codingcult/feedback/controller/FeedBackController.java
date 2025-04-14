package com.codingcult.feedback.controller;

import com.codingcult.feedback.dto.FeedBackDto;
import com.codingcult.feedback.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/feedback")
public class FeedBackController {

    @Autowired
    private FeedBackService feedbackService;

    @PostMapping("/submit")
    public String submitFeedback(@RequestBody FeedBackDto feedback) {
        FeedBackDto saved = feedbackService.saveFeedback(feedback);
        
        // TODO: Integrate PopupNotificationService / LogService
        
        return "Thanks for feedback,:" + saved.getUserMobile();
    }
}
