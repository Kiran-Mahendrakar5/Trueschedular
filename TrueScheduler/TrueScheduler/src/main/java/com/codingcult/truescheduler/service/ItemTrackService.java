package com.codingcult.truescheduler.service;

import com.codingcult.truescheduler.dto.ItemTrackDto;
import java.util.List;
import java.util.Optional;

public interface ItemTrackService {

	public ItemTrackDto saveItemTrack(ItemTrackDto itemTrackDto);

	public List<ItemTrackDto> getAllItemTracks();

	public Optional<ItemTrackDto> getItemTrackById(Long id);

	public ItemTrackDto updateItemTrack(Long id, ItemTrackDto itemTrackDto);

	public void deleteItemTrack(Long id);
}
