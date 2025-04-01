package com.codingcult.purchasedeatails.service;

import java.util.List;

import com.codingcult.purchasedeatails.dto.ItemTrackDto;


public interface ItemTrackService {

    ItemTrackDto saveItemTrack(ItemTrackDto itemTrack);  // Save item tracking details
    List<ItemTrackDto> getAllItemTracks();  // Retrieve all item tracking data
    ItemTrackDto getItemTrackByTrackId(String trackId);  // Retrieve item by trackId
}

