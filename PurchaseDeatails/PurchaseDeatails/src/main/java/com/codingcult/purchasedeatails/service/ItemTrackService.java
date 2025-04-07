package com.codingcult.purchasedeatails.service;

import com.codingcult.purchasedeatails.dto.ItemTrackDto;

import java.util.List;

public interface ItemTrackService {
    ItemTrackDto saveItemTrack(ItemTrackDto itemTrack);
    List<ItemTrackDto> getAllItemTracks();
    ItemTrackDto getItemTrackByTrackId(String trackId);
}
