package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.ItemTrackDto;
import com.codingcult.truescheduler.repo.ItemTrackRepo;
import com.codingcult.truescheduler.service.ItemTrackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemTrackServiceImpl implements ItemTrackService {

    @Autowired
    private ItemTrackRepo itemTrackRepo;

    @Override
    public ItemTrackDto saveItemTrack(ItemTrackDto itemTrackDto) {
        return itemTrackRepo.save(itemTrackDto);
    }

    @Override
    public List<ItemTrackDto> getAllItemTracks() {
        return itemTrackRepo.findAll();
    }

    @Override
    public Optional<ItemTrackDto> getItemTrackById(Long id) {
        return itemTrackRepo.findById(id);
    }

    @Override
    public ItemTrackDto updateItemTrack(Long id, ItemTrackDto itemTrackDto) {
        Optional<ItemTrackDto> existingTrack = itemTrackRepo.findById(id);

        if (existingTrack.isPresent()) {
            ItemTrackDto trackToUpdate = existingTrack.get();
            trackToUpdate.setItemName(itemTrackDto.getItemName());
            trackToUpdate.setOrderTime(itemTrackDto.getOrderTime());
            trackToUpdate.setStatus(itemTrackDto.getStatus());
            trackToUpdate.setTrackId(itemTrackDto.getTrackId());
            trackToUpdate.setLocation(itemTrackDto.getLocation());

            return itemTrackRepo.save(trackToUpdate);
        }

        return null;
    }

    @Override
    public void deleteItemTrack(Long id) {
        itemTrackRepo.deleteById(id);
    }
}
