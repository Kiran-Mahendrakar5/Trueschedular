package com.codingcult.reminder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codingcult.reminder.dto.EventDto;

@FeignClient(name = "friend-service", url = "http://localhost:9005")
public interface FriendServiceClient {

    @PostMapping("/sendBirthdayData")
    String sendBirthdayData(@RequestBody EventDto eventDto);
}

