package com.codingcult.purchasedeatails.service;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingcult.purchasedeatails.dto.ItemTrackDto;
import com.codingcult.purchasedeatails.repo.ItemTrackRepository;


@Service
public class ItemTrackServiceImpl implements ItemTrackService {

    @Autowired
    private ItemTrackRepository itemTrackRepository;

    @Override
    public ItemTrackDto saveItemTrack(ItemTrackDto itemTrack) {
        return itemTrackRepository.save(itemTrack);  // Save item tracking to DB
    }

    @Override
    public List<ItemTrackDto> getAllItemTracks() {
        return itemTrackRepository.findAll();  // Retrieve all item tracking data
    }

    @Override
    public ItemTrackDto getItemTrackByTrackId(String trackId) {
        return itemTrackRepository.findByTrackId(trackId);  // Find item track by trackId
    }
}

