package com.codingcult.reminder.feign;

import com.codingcult.reminder.dto.CalendarEventDto;
import com.codingcult.reminder.dto.ReminderDto;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "wearableClient", url = "http://localhost:9002")
public interface WearableServiceClient {

    @PostMapping("/api/wearables/sync-calendar")
    String syncWithWearable(@RequestBody List<ReminderDto> reminders);
    
    @GetMapping("/reminders/{phoneNumber}")
    List<ReminderDto> getUserReminders(@PathVariable("phoneNumber") String phoneNumber);
    
    @PostMapping("/api/wearables/sync-calendar")
    String syncWithWearable(@RequestBody CalendarEventDto dto);
    
    @PostMapping("/sync")
    String syncToWearable(@RequestBody ReminderDto dto);
    
  

}
