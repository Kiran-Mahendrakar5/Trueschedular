package com.codingcult.purchasedetails.service;

import com.codingcult.purchasedetails.dto.ItemTrackDto;
import com.codingcult.purchasedetails.repo.ItemTrackRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemTrackServiceImpl implements ItemTrackService {

    @Autowired
    private ItemTrackRepo repo;

    @Override
    public ItemTrackDto addTrack(ItemTrackDto dto) {
        return repo.save(dto);
    }

    @Override
    public List<ItemTrackDto> getTracksByMobile(String mobile) {
        return repo.findByUserMobile(mobile);
    }

    @Override
    public ItemTrackDto updateStatus(int id, String status) {
        Optional<ItemTrackDto> optional = repo.findById(id);
        if (optional.isPresent()) {
            ItemTrackDto dto = optional.get();
            dto.setStatus(status);
            return repo.save(dto);
        }
        return null;
    }

    @Override
    public ItemTrackDto addNoteOrReceipt(int id, String note, String receipt) {
        Optional<ItemTrackDto> optional = repo.findById(id);
        if (optional.isPresent()) {
            ItemTrackDto dto = optional.get();
            dto.setNote(note);
            dto.setReceipt(receipt);
            return repo.save(dto);
        }
        return null;
    }
}