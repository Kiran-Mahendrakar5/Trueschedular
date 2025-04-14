package com.codingcult.reminder.feign;

import com.codingcult.reminder.dto.CalendarEventDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "wearableClient", url = "${wearable.service.url}")
public interface WearableServiceClient {

    @PostMapping("/api/wearables/sync-calendar")
    String syncWithWearable(@RequestBody CalendarEventDto dto);
}
