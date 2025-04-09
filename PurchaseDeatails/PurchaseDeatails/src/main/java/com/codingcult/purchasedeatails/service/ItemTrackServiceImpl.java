package com.codingcult.purchasedeatails.service;

import com.codingcult.purchasedeatails.dto.ItemTrackDto;
import com.codingcult.purchasedeatails.repo.ItemTrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemTrackServiceImpl implements ItemTrackService {

    @Autowired
    private ItemTrackRepository itemTrackRepository;

    @Override
    public ItemTrackDto saveItemTrack(ItemTrackDto itemTrack) {
        return itemTrackRepository.save(itemTrack);
    }

    @Override
    public List<ItemTrackDto> getAllItemTracks() {
        return itemTrackRepository.findAll();
    }

    @Override
    public ItemTrackDto getItemTrackByTrackId(String trackId) {
        return itemTrackRepository.findByTrackId(trackId);
    }
}
