package com.codingcult.purchasedetails.service;

import java.util.List;

import com.codingcult.purchasedetails.dto.ItemTrackDto;
import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;

public interface ItemTrackService {
    ItemTrackDto addTrack(ItemTrackDto dto);
    List<ItemTrackDto> getTracksByMobile(String mobile);
    ItemTrackDto updateStatus(int id, String status);
    ItemTrackDto addNoteOrReceipt(int id, String note, String receipt);
	List<ItemTrackDto> generateTracksFromPurchases(String mobile);
	
	public void saveItems(List<PurchaseIteamsDto> items);
}