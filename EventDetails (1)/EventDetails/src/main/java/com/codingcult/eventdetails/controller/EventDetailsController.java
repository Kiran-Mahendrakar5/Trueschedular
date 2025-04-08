package com.codingcult.eventdetails.controller;

import com.codingcult.eventdetails.dto.EventDetailsDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@Service
public class EventDetailsController {

    private final RestTemplate restTemplate;

    @Value("${event.details.service.url}")
    private String BASE_URL;

    public EventDetailsController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<EventDetailsDTO> fetchAllEvents() {
        try {
            ResponseEntity<List<EventDetailsDTO>> response = restTemplate.exchange(
                BASE_URL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EventDetailsDTO>>() {}
            );
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public EventDetailsDTO getEventById(Long id) {
        try {
            return restTemplate.getForObject(BASE_URL + "/" + id, EventDetailsDTO.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<EventDetailsDTO> getEventsByPhone(String phoneNumber) {
        try {
            String url = BASE_URL + "/phone/" + phoneNumber;
            ResponseEntity<List<EventDetailsDTO>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<EventDetailsDTO>>() {}
            );
            return response.getBody();
        } catch (RestClientException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public EventDetailsDTO createEvent(EventDetailsDTO dto) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<EventDetailsDTO> request = new HttpEntity<>(dto, headers);
            return restTemplate.postForObject(BASE_URL, request, EventDetailsDTO.class);
        } catch (RestClientException e) {
            e.printStackTrace();
            return null;
        }
    }
}
