package com.codingcult.reminder.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codingcult.reminder.dto.EventDto;

@FeignClient(name = "calendar-service", url = "http://localhost:9003")
public interface CalendarServiceClient {

    @PostMapping("/updateEvent")
    String updateEvent(@RequestBody EventDto eventDto);
}

