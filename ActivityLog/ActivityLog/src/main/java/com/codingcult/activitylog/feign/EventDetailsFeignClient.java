package com.codingcult.activitylog.feign;





import java.util.List;
import com.codingcult.eventdetails.dto.EventDetailsDTO;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "event-details-service", url = "http://localhost:8081") // Replace with actual service URL/port
public interface EventDetailsFeignClient {

    @GetMapping("/api/eventdetails")
    List<EventDetailsDTO> getAllEvents();

    @GetMapping("/api/eventdetails/phone/{phoneNumber}")
    List<EventDetailsDTO> getEventsByPhoneNumber(@PathVariable("phoneNumber") String phoneNumber);

    @PostMapping("/api/eventdetails")
    EventDetailsDTO createEvent(@RequestBody EventDetailsDTO dto);
}
