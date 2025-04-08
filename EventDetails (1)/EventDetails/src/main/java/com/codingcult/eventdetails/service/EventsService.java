package com.codingcult.eventdetails.service;

import com.codingcult.eventdetails.dto.EventsDTO;

import java.util.List;

public interface EventsService {
    EventsDTO save(EventsDTO dto);
    List<EventsDTO> getAll();
    List<EventsDTO> getByPhoneNumber(String phoneNumber);
    EventsDTO update(Long id, EventsDTO dto);
    boolean delete(Long id);
}