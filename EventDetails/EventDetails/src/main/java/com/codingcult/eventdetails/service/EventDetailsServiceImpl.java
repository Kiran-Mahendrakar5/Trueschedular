package com.codingcult.eventdetails.service;

import com.codingcult.eventdetails.dto.EventDetailsDTO;
import com.codingcult.eventdetails.repo.EventDetailsRepository;
import com.codingcult.eventdetails.service.EventDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventDetailsServiceImpl implements EventDetailsService {

    @Autowired
    private EventDetailsRepository repository;

    @Override
    public EventDetailsDTO createEvent(EventDetailsDTO dto) {
        return repository.save(dto);
    }

    @Override
    public EventDetailsDTO updateEvent(Long id, EventDetailsDTO dto) {
        Optional<EventDetailsDTO> existing = repository.findById(id);
        if (existing.isPresent()) {
            dto.setId(id);
            return repository.save(dto);
        }
        return null;
    }

    @Override
    public boolean deleteEvent(Long id) {
        Optional<EventDetailsDTO> optional = repository.findById(id);
        if (optional.isPresent()) {
            EventDetailsDTO dto = optional.get();
            dto.setActive(false); // Soft delete
            repository.save(dto);
            return true;
        }
        return false;
    }

    @Override
    public List<EventDetailsDTO> getAllEvents() {
        return repository.findByIsActiveTrue();
    }

    @Override
    public EventDetailsDTO getEventById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public List<EventDetailsDTO> getEventsByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumberAndIsActiveTrue(phoneNumber);
    }
}