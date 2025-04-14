package com.codingcult.feedback.service;

import com.codingcult.feedback.dto.FeedBackDto;
import com.codingcult.feedback.repo.FeedBackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FeedBackServiceImple implements FeedBackService {

    @Autowired
    private FeedBackRepo feedBackRepo;

    @Override
    public FeedBackDto saveFeedback(FeedBackDto feedback) {
        // Add created timestamp
        feedback.setCreatedTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        
        // Save to DB
        FeedBackDto saved = feedBackRepo.save(feedback);
        
        

        return saved;
    }
}
