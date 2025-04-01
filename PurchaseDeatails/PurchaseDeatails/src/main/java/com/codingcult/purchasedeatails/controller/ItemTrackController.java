package com.codingcult.purchasedeatails.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.codingcult.purchasedeatails.dto.ItemTrackDto;
import com.codingcult.purchasedeatails.service.ItemTrackService;



@RestController
@RequestMapping("/api/itemtrack")
public class ItemTrackController {

    @Autowired
    private ItemTrackService itemTrackService;

    @PostMapping
    public ItemTrackDto addItemTrack(@RequestBody ItemTrackDto itemTrack) {
        return itemTrackService.saveItemTrack(itemTrack);  // Save item track data
    }

    @GetMapping
    public List<ItemTrackDto> getAllItemTracks() {
        return itemTrackService.getAllItemTracks();  // Get all item tracks
    }

    @GetMapping("/{trackId}")
    public ItemTrackDto getItemTrack(@PathVariable String trackId) {
        return itemTrackService.getItemTrackByTrackId(trackId);  // Get item track by trackId
    }
}
