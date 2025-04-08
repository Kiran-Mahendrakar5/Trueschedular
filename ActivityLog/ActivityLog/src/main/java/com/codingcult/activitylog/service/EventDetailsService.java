package com.codingcult.activitylog.service;

import com.codingcult.activitylog.feign.EventDetailsFeignClient;
import com.codingcult.eventdetails.dto.EventDetailsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventDetailsService {

    @Autowired
    private EventDetailsFeignClient feignClient;

    public List<EventDetailsDTO> fetchAllEvents() {
        return feignClient.getAllEvents();
    }

    public List<EventDetailsDTO> getEventsByPhone(String phoneNumber) {
        return feignClient.getEventsByPhoneNumber(phoneNumber);
    }

    public EventDetailsDTO createEvent(EventDetailsDTO dto) {
        return feignClient.createEvent(dto);
    }
}
