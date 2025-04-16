package com.codingcult.reminder.feign;

import java.time.LocalDateTime;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingcult.reminder.dto.ReminderDto;

@FeignClient(name = "notification-service", url = "http://localhost:9002") // Update URL accordingly
public interface NotificationServiceClient {

    @PostMapping("/notification/schedule")
    void scheduleNotification(@RequestBody ReminderDto reminder, @RequestParam LocalDateTime alertTime);
}
