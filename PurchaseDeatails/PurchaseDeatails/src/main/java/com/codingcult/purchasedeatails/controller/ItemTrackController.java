package com.codingcult.purchasedeatails.controller;

import com.codingcult.purchasedeatails.dto.ItemTrackDto;
import com.codingcult.purchasedeatails.service.ItemTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/itemtrack")
public class ItemTrackController {

    @Autowired
    private ItemTrackService itemTrackService;

    @PostMapping
    public ItemTrackDto addItemTrack(@RequestBody ItemTrackDto itemTrack) {
        return itemTrackService.saveItemTrack(itemTrack);
    }

    @GetMapping
    public List<ItemTrackDto> getAllItemTracks() {
        return itemTrackService.getAllItemTracks();
    }

    @GetMapping("/{trackId}")
    public ItemTrackDto getItemTrack(@PathVariable String trackId) {
        return itemTrackService.getItemTrackByTrackId(trackId);
    }
}
