package com.codingcult.reminder.feign;

import com.codingcult.reminder.dto.CalendarEventDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "reminder-service", url = "${reminder.service.url}")
public interface ReminderServiceClient {
    @PostMapping("/api/reminders/from-calendar")
    void sendReminderFromCalendar(@RequestBody CalendarEventDto event);
}



