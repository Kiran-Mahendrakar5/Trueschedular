package com.codingcult.activitylog.service;

import com.codingcult.activitylog.dto.Scheduling_UserPurchaseDto;
import com.codingcult.activitylog.repo.SchedulingUserPurchaseRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SchedulingUserPurchaseService implements SchedulingUserPurchaseServiceInterface {

    @Autowired
    private SchedulingUserPurchaseRepository repository;

    @Override
    public Scheduling_UserPurchaseDto savePurchase(Scheduling_UserPurchaseDto dto) {
        return repository.save(dto);
    }

    @Override
    public List<Scheduling_UserPurchaseDto> getAllPurchases() {
        return repository.findByIsActiveTrue();
    }

    @Override
    public Optional<Scheduling_UserPurchaseDto> getPurchaseById(Long id) {
        return repository.findById(id).filter(Scheduling_UserPurchaseDto::isActive);
    }

    @Override
    public Scheduling_UserPurchaseDto updatePurchase(Long id, Scheduling_UserPurchaseDto newDto) {
        return repository.findById(id).map(existing -> {
            existing.setUserName(newDto.getUserName());
            existing.setItem(newDto.getItem());
            existing.setAmount(newDto.getAmount());
            existing.setLocation(newDto.getLocation());
            existing.setPurchaseTime(newDto.getPurchaseTime());
            return repository.save(existing);
        }).orElseThrow(() -> new RuntimeException("Purchase not found"));
    }

    @Override
    public int deletePurchase(Long id) {
        return repository.findById(id).map(p -> {
            p.setActive(false);
            repository.save(p);
            return 1;
        }).orElse(0);
    }
}
