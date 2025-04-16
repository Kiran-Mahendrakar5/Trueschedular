
package com.codingcult.purchasedetails.controller;

import com.codingcult.purchasedetails.client.PurchaseServiceClient;
import com.codingcult.purchasedetails.dto.ItemTrackDto;
import com.codingcult.purchasedetails.dto.PurchaseIteamsDto;
import com.codingcult.purchasedetails.service.ItemTrackService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/track")
public class ItemTrackController {

	@Autowired
	private ItemTrackService service;

	@Autowired
	private PurchaseServiceClient purchaseServiceClient;

	@GetMapping("/fetch-from-purchase/{mobile}")
	public List<PurchaseIteamsDto> fetchAndStoreItems(@PathVariable String mobile) {
	    // Fetch purchase items using Feign client
	    List<PurchaseIteamsDto> items = purchaseServiceClient.getItemsByMobile(mobile);

	    if (items.isEmpty()) {
	        return Collections.emptyList(); // Return an empty list if no items are found
	    }

	    return items; // Return the fetched items
	}


	@PostMapping("/add")
	public ItemTrackDto addTrack(@RequestBody ItemTrackDto dto) {
		return service.addTrack(dto);
	}

	@GetMapping("/mobile/{mobile}")
	public List<ItemTrackDto> getTracks(@PathVariable String mobile) {
		return service.getTracksByMobile(mobile);
	}

	@PutMapping("/status/{id}")
	public ItemTrackDto updateStatus(@PathVariable int id, @RequestParam String status) {
		return service.updateStatus(id, status);
	}

	@PutMapping("/note-receipt/{id}")
	public ItemTrackDto addNoteReceipt(@PathVariable int id, @RequestParam(required = false) String note,
			@RequestParam(required = false) String receipt) {
		return service.addNoteOrReceipt(id, note, receipt);
	}

	@GetMapping("/generate/{mobile}")
	public List<ItemTrackDto> generateTracks(@PathVariable String mobile) {
		return service.generateTracksFromPurchases(mobile);
	}

}
