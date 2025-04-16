package com.codingcult.reminder.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.codingcult.reminder.dto.EventDto;

@FeignClient(name = "event-service", url = "http://localhost:9002")
public interface EventServiceClient {

    @GetMapping("/api/events/user/{phoneNumber}")
    List<EventDto> getEvents(@PathVariable String phoneNumber);

    @PostMapping("/api/events")
    String createEvent(@RequestBody EventDto dto);
}

