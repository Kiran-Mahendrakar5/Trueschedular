package com.codingcult.eventdetails.service;

import com.codingcult.eventdetails.dto.EventsDTO;
import com.codingcult.eventdetails.repo.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventsServiceImpl implements EventsService {

    @Autowired
    private EventsRepository repository;

    @Override
    public EventsDTO save(EventsDTO dto) {
        return repository.save(dto);
    }

    @Override
    public List<EventsDTO> getAll() {
        return repository.findByIsActiveTrue();
    }

    @Override
    public List<EventsDTO> getByPhoneNumber(String phoneNumber) {
        return repository.findByPhoneNumberAndIsActiveTrue(phoneNumber);
    }

    @Override
    public EventsDTO update(Long id, EventsDTO dto) {
        Optional<EventsDTO> existing = repository.findById(id);
        if (existing.isPresent()) {
            dto.setId(id);
            return repository.save(dto);
        }
        return null;
    }

    @Override
    public boolean delete(Long id) {
        Optional<EventsDTO> existing = repository.findById(id);
        if (existing.isPresent()) {
            EventsDTO dto = existing.get();
            dto.setActive(false);
            repository.save(dto);
            return true;
        }
        return false;
    }
}